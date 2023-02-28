package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastItem

sealed class DetailAction : Action {
    data class GetForecastItem(val forecastItem: ForecastItem) : DetailAction()

    data class ShowError(val failureResponse: FailureResponse): DetailAction()
    object ClearErrorState: DetailAction()
}