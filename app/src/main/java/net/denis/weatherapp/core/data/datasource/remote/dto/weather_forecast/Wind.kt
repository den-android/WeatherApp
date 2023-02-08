package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep

@Keep
data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
)