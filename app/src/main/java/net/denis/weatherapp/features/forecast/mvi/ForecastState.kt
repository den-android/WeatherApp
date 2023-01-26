package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast.model.MultipleView

data class ForecastState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val meteorologyItem: MeteorologyItem? = null
) : State