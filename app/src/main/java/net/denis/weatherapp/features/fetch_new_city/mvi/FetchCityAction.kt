package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import net.denis.weatherapp.features.main_forecast.mvi.MainAction

sealed class FetchCityAction: Action {
    data class FetchCity(val name: String): FetchCityAction()
    data class CityLoaded(val cityData: CityData): FetchCityAction()

    data class ShowError(val failureResponse: FailureResponse): FetchCityAction()
    object ClearErrorState: FetchCityAction()
}