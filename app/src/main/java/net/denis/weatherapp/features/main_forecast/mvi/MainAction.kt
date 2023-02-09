package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastData

sealed class MainAction : Action {
    object FetchForecast : MainAction()
    data class ForecastLoaded(val forecastData: ForecastData) : MainAction()
    data class FetchForecastByCoords(val lat: Double, val lon: Double) : MainAction()
}