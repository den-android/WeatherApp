package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.HourlyItem

sealed class MainAction : Action {
    //data class FetchForecast(val lat: Double, val lon: Double) : MainAction()
    object FetchForecast : MainAction()
    object FetchingForecast : MainAction()
    data class ForecastLoaded(val forecastData: ForecastData) : MainAction()

    data class ShowError(val failureResponse: FailureResponse) : MainAction()
    object FixError : MainAction()

    object ClearErrorState : MainAction()

    //data class NavigateToDetail(val hourlyItem: HourlyItem) : MainAction()
    object NavigateTo: MainAction()
}