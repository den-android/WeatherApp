package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.presentation.redux.State

data class ForecastState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val weather: WeatherDto? = null
) : State