package net.denis.weatherapp.features.detail_forecast.mvi

import androidx.annotation.Keep
import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.main_forecast.model.ForecastItem

@Keep
data class DetailState(
    val isLoading: Boolean = false,
    val error: FailureResponse? = null,
    val forecastItem: ForecastItem? = null,
) : State