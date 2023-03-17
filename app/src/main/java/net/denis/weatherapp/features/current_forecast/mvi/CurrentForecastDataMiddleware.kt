package net.denis.weatherapp.features.current_forecast.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.mapToForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import net.denis.weatherapp.core.presentation.navigation.NavigationManager
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.core.util.OnExceptionError
import net.denis.weatherapp.core.util.OnHttpError
import net.denis.weatherapp.core.util.network.NetworkResult
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class CurrentForecastDataMiddleware(
    private val weatherRepository: IWeatherRepository,
    private val navigationManager: NavigationManager
) : Middleware<CurrentForecastState, CurrentForecastAction> {

    override suspend fun process(
        action: CurrentForecastAction,
        currentState: CurrentForecastState,
        store: Store<CurrentForecastState, CurrentForecastAction>
    ) {
        when (action) {
            is CurrentForecastAction.FetchForecast -> {
                fetchForecast(store = store)
            }

            is CurrentForecastAction.NavigateTo -> {
               navigateWithParams(params = action.params, destination = action.destination)
            }

            is CurrentForecastAction.OnActionErrorClicked -> {
                handlerErrors(currentState.failureResponse, store)
            }

            else -> currentState
        }
    }

    private suspend fun fetchForecast(store: Store<CurrentForecastState, CurrentForecastAction>) {
        val cityData = readCityCoords()
        store.dispatch(CurrentForecastAction.FetchingForecast)
        weatherRepository.fetchForecast(lat = cityData.lat, lon = cityData.lon)
            .collect { response ->
                when (response) {
                    is NetworkResult.Success -> {
                        store.dispatch(
                            CurrentForecastAction.ForecastLoaded(forecastData = response.data.mapToForecastData())
                        )
                    }
                    is NetworkResult.Failure -> {
                        handlerHttpCode(response.code, store)
                    }
                    is NetworkResult.Exception -> {
                        handlerException(response.e, store)
                    }
                }
            }
    }

    private suspend fun navigateWithParams(params: Any?, destination: INavigationCommand) {
        when (params) {
            is DetailData -> {
                writeDetailData(detailData = params)
            }
        }
        navigationManager.navigate(destination)
    }

    private suspend fun writeDetailData(detailData: DetailData) {
        weatherRepository.writeDetailParams(detailData = detailData)
    }

    private suspend fun readCityCoords()  = weatherRepository.readCityCoords()

    private suspend fun handlerErrors(
        failureResponse: FailureResponse?,
        store: Store<CurrentForecastState, CurrentForecastAction>
    ) {
        when (failureResponse) {
            OnHttpError.Code1 -> store.dispatch(CurrentForecastAction.FetchForecast)
            OnHttpError.Code2 -> {}
            OnHttpError.Code401 -> store.dispatch(CurrentForecastAction.FetchForecast)

            OnExceptionError.ExUnknownHostException -> {
                store.dispatch(CurrentForecastAction.ClearErrorState)
                store.dispatch(CurrentForecastAction.FetchForecast)
            }
            OnExceptionError.ExSocketTimeoutException -> {
                store.dispatch(CurrentForecastAction.FetchForecast)
            }
            OnExceptionError.ExHttpException -> {
                store.dispatch(CurrentForecastAction.FetchForecast)
            }
            null -> Log.d("Logging", "MainAction.OnActionErrorClicked -> null")
        }
    }

    private suspend fun handlerHttpCode(
        code: Int,
        store: Store<CurrentForecastState, CurrentForecastAction>
    ) {
        when (code) {
            1 -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnHttpError.Code1))
            }
            2 -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnHttpError.Code2))
            }
            401 -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnHttpError.Code401))
            }
        }
    }

    private suspend fun handlerException(
        ex: Exception,
        store: Store<CurrentForecastState, CurrentForecastAction>
    ) {
        when (ex) {
            is UnknownHostException -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnExceptionError.ExUnknownHostException))
            }
            is SocketTimeoutException -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnExceptionError.ExSocketTimeoutException))
            }
            is HttpException -> {
                store.dispatch(CurrentForecastAction.SendErrorToUI(OnExceptionError.ExHttpException))
            }
        }
    }
}