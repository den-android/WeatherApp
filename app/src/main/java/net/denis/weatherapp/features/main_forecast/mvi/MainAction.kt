package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.error.ErrorType
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastData

sealed class MainAction : Action {
    data class FetchForecast(val lat: Double, val lon: Double) : MainAction()
    object FetchingForecast : MainAction()
    data class ForecastLoaded(val forecastData: ForecastData) : MainAction()

    data class ShowError(val errorType: ErrorType): MainAction()
}