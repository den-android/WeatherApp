package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.Action

sealed class FetchCityAction: Action {
    data class FetchingCity(val name: String): FetchCityAction()
}