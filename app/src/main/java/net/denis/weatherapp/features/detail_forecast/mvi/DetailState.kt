package net.denis.weatherapp.features.detail_forecast.mvi

import androidx.annotation.Keep
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.current_forecast.model.HourlyItem
import net.denis.weatherapp.features.detail_forecast.model.DetailData

@Keep
data class DetailState(
    val isLoading: Boolean = false,
    val failureResponse: FailureResponse? = null,
    val detailData: DetailData? = null,
) : State