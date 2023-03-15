package net.denis.weatherapp.features.current_forecast.model

import androidx.annotation.Keep

@Keep
data class Meteorology(
    val id: Int,
    val description: String
)