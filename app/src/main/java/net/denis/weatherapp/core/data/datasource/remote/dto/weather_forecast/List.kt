package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import kotlin.collections.List

data class List(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)