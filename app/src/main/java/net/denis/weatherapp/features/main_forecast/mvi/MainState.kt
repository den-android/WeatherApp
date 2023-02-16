package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.main_forecast.model.ForecastData

data class MainState(
    val isLoading: Boolean = false,
    val error: FailureResponse? = null,
    val forecastData: ForecastData? = null
) : State