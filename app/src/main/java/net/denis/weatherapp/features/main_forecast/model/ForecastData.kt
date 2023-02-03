package net.denis.weatherapp.features.main_forecast.model

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City

data class ForecastData(
    val city: City,
    val forecastList: List<ForecastItem>,
)