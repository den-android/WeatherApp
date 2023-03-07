package net.denis.weatherapp.features.fetch_new_city.mvi

import androidx.annotation.Keep
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.features.fetch_new_city.model.CityData

@Keep
data class FetchCityState(
    val isLoading: Boolean = false,
    val failureResponse: FailureResponse? = null,
    val cityData: CityData? = null
) : State