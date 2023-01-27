package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.core.Forecast
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail

sealed class DetailAction : Action {
    data class GetCurrentId(val currentId: Int): DetailAction()
    data class DetailForecastLoaded(val detail: Detail) : DetailAction()
}