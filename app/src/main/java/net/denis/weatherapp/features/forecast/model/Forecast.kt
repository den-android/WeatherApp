package net.denis.weatherapp.features.forecast.model

import kotlin.collections.List

data class Forecast(
    val clouds: Clouds,
    val dt: Int,
    val main: Main,
    val visibility: Int,
    val meteorology: List<Meteorology>,
    val wind: Wind
)