package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep

@Keep
data class Coord(
    val lat: Double,
    val lon: Double
)