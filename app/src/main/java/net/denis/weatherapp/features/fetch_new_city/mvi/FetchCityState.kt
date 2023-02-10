package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.fetch_new_city.model.CityData

data class FetchCityState(
    val isLoading: Boolean = false,
    val cityData: CityData? = null
): State