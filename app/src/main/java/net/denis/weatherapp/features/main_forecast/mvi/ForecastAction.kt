package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastData

sealed class ForecastAction : Action {
    object ForecastLoading : ForecastAction()
   data class CurrentForecastLoaded(val forecastData: ForecastData) : ForecastAction()
}