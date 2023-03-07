package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.main_forecast.model.ForecastData

sealed class MainAction : Action {
    object FetchForecast : MainAction()
    object FetchingForecast : MainAction()
    data class ForecastLoaded(val forecastData: ForecastData) : MainAction()

    data class SendErrorToUI(val failureResponse: FailureResponse) : MainAction()
    object OnActionErrorClicked : MainAction()

    object ClearErrorState : MainAction()

    object NavigateTo : MainAction()
}