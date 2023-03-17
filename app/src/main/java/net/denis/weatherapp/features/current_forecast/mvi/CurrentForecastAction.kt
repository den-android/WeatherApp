package net.denis.weatherapp.features.current_forecast.mvi

import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.current_forecast.model.ForecastData
import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class CurrentForecastAction : Action {
    object FetchForecast : CurrentForecastAction()
    object FetchingForecast : CurrentForecastAction()
    data class ForecastLoaded(val forecastData: ForecastData) : CurrentForecastAction()

    data class SendErrorToUI(val failureResponse: FailureResponse) : CurrentForecastAction()
    object OnActionErrorClicked : CurrentForecastAction()

    object ClearErrorState : CurrentForecastAction()

    data class NavigateTo(val destination: INavigationCommand, val params: DetailData) : CurrentForecastAction()
}