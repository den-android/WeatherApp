package net.denis.weatherapp.features.main_forecast.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.toForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.error.ErrorType
import net.denis.weatherapp.core.presentation.error.model.HttpErrorResponse
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.handleHttpCode

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
                fetchForecast(lat = action.lat, lon = action.lon, store = store)
            }

            is MainAction.ShowError -> {
                errorHandling(action.errorType)
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
                    store.dispatch(MainAction.ForecastLoaded(forecastData = response.data.toForecastData()))
                }
                is NetworkResult.Failure -> {
                    store.dispatch(
                        MainAction.ShowError(
                            ErrorType.HttpError(
                                HttpErrorResponse(
                                    code = response.code, message = response.message
                                )
                            )
                        )
                    )
                }
                is NetworkResult.Exception -> {
                    store.dispatch(
                        MainAction.ShowError(
                            ErrorType.OnExceptionError(
                                response.e.localizedMessage
                            )
                        )
                    )
                }
            }
        }
    }

    private fun errorHandling(errorType: ErrorType) {
        when (errorType) {
            is ErrorType.HttpError -> {
                handleHttpCode(errorType.httpErrorResponse.code)
            }
            is ErrorType.OnExceptionError -> {
                Log.d("Logging", "${errorType.exMessage}")
            }
        }
    }
}