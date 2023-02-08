package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.main_forecast.model.ForecastData

data class MainState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val forecastData: ForecastData? = null
) : State