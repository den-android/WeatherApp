package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast_at_three_hour.model.TestDetailData

data class DetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val testDetailData: List<MultipleView>? = null,
) : State