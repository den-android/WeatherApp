package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.detail_forecast.model.DetailData

data class DetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val detailData: DetailData? = null,
) : State