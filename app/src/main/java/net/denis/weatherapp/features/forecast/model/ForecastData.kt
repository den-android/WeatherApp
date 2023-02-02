package net.denis.weatherapp.features.forecast.model

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City

data class ForecastData(
    val city: City,
    val forecastItem: List<ForecastItem>,
)