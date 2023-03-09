package net.denis.weatherapp.features.current_forecast.model

import androidx.annotation.Keep

@Keep
data class ForecastItem(
    val dateTime: String,
    val meteorology: List<Meteorology>,
    val temp: String,
)