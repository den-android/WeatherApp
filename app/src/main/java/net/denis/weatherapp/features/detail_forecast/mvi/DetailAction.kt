package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.current_forecast.model.HourlyItem

sealed class DetailAction : Action {
    data class GetHourlyItem(val hourlyItem: HourlyItem) : DetailAction()
}