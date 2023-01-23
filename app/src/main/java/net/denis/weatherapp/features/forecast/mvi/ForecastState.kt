package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.presentation.redux.State

data class ForecastState(
    val isLoading: Boolean = false,
    val error: String? = null,

) : State