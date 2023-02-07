package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.features.fetch_new_city.model.FetchCityData

data class FetchCityState(
    val isLoading: Boolean = false,
    val cityName: String? = null
): State