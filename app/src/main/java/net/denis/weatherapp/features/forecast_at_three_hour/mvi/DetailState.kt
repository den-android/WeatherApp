package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailItem

data class DetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val detailData: DetailData? = null,
) : State