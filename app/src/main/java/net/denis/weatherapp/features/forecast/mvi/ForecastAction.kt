package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.presentation.redux.Action

sealed class ForecastAction : Action {

    object ForecastLoading : ForecastAction()
    data class ForecastLoaded(val items: WeatherDto) : ForecastAction()

}