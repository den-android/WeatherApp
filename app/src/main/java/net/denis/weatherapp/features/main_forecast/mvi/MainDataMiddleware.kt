package net.denis.weatherapp.features.main_forecast.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.mapToForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.core.util.OnExceptionError
import net.denis.weatherapp.core.util.OnHttpError
import net.denis.weatherapp.core.util.network.NetworkResult
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MainDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<MainState, MainAction> {

    override suspend fun process(
        action: MainAction,
        currentState: MainState,
        store: Store<MainState, MainAction>
    ) {
        when (action) {
            is MainAction.FetchForecast -> {
                fetchForecast(lat = 47.2213858, lon = 39.7114196, store = store)
            }

            is MainAction.OnActionErrorClicked -> {
                handlerErrors(currentState.failureResponse, store)
            }

            else -> currentState
        }
    }

    private suspend fun fetchForecast(
        lat: Double,
        lon: Double,
        store: Store<MainState, MainAction>
    ) {
        store.dispatch(MainAction.FetchingForecast)
        weatherRepository.fetchForecast(lat = lat, lon = lon).collect { response ->
            when (response) {
                is NetworkResult.Success -> {
                    store.dispatch(
                        MainAction.ForecastLoaded(forecastData = response.data.mapToForecastData())
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
    private suspend fun handlerErrors(failureResponse: FailureResponse?, store: Store<MainState, MainAction>) {
        when (failureResponse) {
            OnHttpError.Code1 -> store.dispatch(MainAction.FetchForecast)
            OnHttpError.Code2 -> {}
            OnHttpError.Code401 -> store.dispatch(MainAction.FetchForecast)

            OnExceptionError.ExUnknownHostException -> {
                store.dispatch(MainAction.ClearErrorState)
                store.dispatch(MainAction.FetchForecast)
            }
            OnExceptionError.ExSocketTimeoutException -> {
                store.dispatch(MainAction.FetchForecast)
            }
            OnExceptionError.ExHttpException -> {
                store.dispatch(MainAction.FetchForecast)
            }
            null -> Log.d("Logging", "MainAction.FixError -> null")
        }
    }

    private suspend fun handlerHttpCode(code: Int, store: Store<MainState, MainAction>) {
        when (code) {
            1 -> {
                store.dispatch(MainAction.SendErrorToUI(OnHttpError.Code1))
            }
            2 -> {
                store.dispatch(MainAction.SendErrorToUI(OnHttpError.Code2))
            }
            401 -> {
                store.dispatch(MainAction.SendErrorToUI(OnHttpError.Code401))
            }
        }
    }

    private suspend fun handlerException(ex: Exception, store: Store<MainState, MainAction>) {
        when (ex) {
            is UnknownHostException -> {
                store.dispatch(MainAction.SendErrorToUI(OnExceptionError.ExUnknownHostException))
            }
            is SocketTimeoutException -> {
                store.dispatch(MainAction.SendErrorToUI(OnExceptionError.ExSocketTimeoutException))
            }
            is HttpException -> {
                store.dispatch(MainAction.SendErrorToUI(OnExceptionError.ExHttpException))
            }
        }
    }

}