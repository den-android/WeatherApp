package net.denis.weatherapp.features.forecast.model

import net.denis.weatherapp.features.forecast_at_three_hour.model.Cloud
import net.denis.weatherapp.features.forecast_at_three_hour.model.Wind
import kotlin.collections.List

data class ForecastMain(
    val cloud: Cloud,
    val dt: Int,
    val main: Main,
    val visibility: Int,
    val meteorology: List<Meteorology>,
    val wind: Wind
)