package net.denis.weatherapp.features.current_forecast.mvi

import androidx.annotation.Keep
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.current_forecast.model.ForecastData

@Keep
data class CurrentForecastState(
    val isLoading: Boolean = false,
    val failureResponse: FailureResponse? = null,
    val forecastData: ForecastData? = null
) : State