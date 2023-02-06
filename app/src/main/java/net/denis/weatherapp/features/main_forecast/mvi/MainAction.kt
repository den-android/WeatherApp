package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastData

sealed class MainAction : Action {
    object ForecastLoading : MainAction()
    data class ForecastLoaded(val forecastData: ForecastData) : MainAction()
}