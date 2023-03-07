package net.denis.weatherapp.features.main_forecast.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.mapToForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.OnExceptionError
import net.denis.weatherapp.core.util.OnHttpError
import net.denis.weatherapp.core.util.network.NetworkResult
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

            is MainAction.FixError -> {
                when (currentState.failureResponse) {
                    OnHttpError.Code1 -> store.dispatch(MainAction.FetchForecast)
                    OnHttpError.Code2 -> {}
                    OnHttpError.Code401 -> store.dispatch(MainAction.FetchForecast)

                    OnExceptionError.ExUnknownHostException -> {
                        store.dispatch(MainAction.FetchForecast)
                    }
                    OnExceptionError.ExSocketTimeoutException -> {
                        store.dispatch(MainAction.FetchForecast)
                    }
                    null -> Log.d("Logging", "MainAction.FixError -> null")
                }

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
                    Log.d("Logging", "AAA")
                    handlerException(response.e, store)
                }
            }
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
//            is SocketTimeoutException -> {
//                store.dispatch(MainAction.ShowError(OnExceptionError.ExSocketTimeoutException))
//            }
        }
    }

}