package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.fetch_new_city.model.CityData

sealed class FetchCityAction: Action {
    data class FetchingCity(val name: String): FetchCityAction()
    data class CityLoaded(val cityData: CityData): FetchCityAction()
}