package net.denis.weatherapp.features.forecast.model

data class ForecastItem(
    val dt: Int,
    val main: Main,
    val meteorology: List<Meteorology>,
)