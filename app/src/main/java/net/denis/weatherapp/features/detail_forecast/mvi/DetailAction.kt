package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastItem
import net.denis.weatherapp.features.main_forecast.model.HourlyItem

sealed class DetailAction : Action {
    data class GetHourlyItem(val hourlyItem: HourlyItem) : DetailAction()

    data class ShowError(val failureResponse: FailureResponse): DetailAction()
    object ClearErrorState: DetailAction()
}