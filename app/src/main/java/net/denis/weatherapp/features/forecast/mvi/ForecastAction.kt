package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.forecast.model.ForecastData

sealed class ForecastAction : Action {
    object ForecastLoading : ForecastAction()
   data class CurrentForecastLoaded(val forecastData: ForecastData) : ForecastAction()
}