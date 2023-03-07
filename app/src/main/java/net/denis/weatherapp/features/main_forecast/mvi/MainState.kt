package net.denis.weatherapp.features.main_forecast.mvi

import androidx.annotation.Keep
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.main_forecast.model.ForecastData

@Keep
data class MainState(
    val isLoading: Boolean = false,
    val failureResponse: FailureResponse? = null,
    val forecastData: ForecastData? = null
) : State