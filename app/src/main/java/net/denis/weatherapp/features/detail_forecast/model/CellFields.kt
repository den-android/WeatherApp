package net.denis.weatherapp.features.detail_forecast.model

import androidx.annotation.Keep

@Keep
data class CellFields(
    val title: String,
    val text: String?,
    val description: String?,
    val indicatorValue: Float?,
)