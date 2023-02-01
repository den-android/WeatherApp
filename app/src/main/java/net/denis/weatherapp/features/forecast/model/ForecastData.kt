package net.denis.weatherapp.features.forecast.model

data class ForecastData(
    val city: City,
    val forecastItem: List<ForecastItem>,
)