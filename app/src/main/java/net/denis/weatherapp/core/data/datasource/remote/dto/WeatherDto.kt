package net.denis.weatherapp.core.data.datasource.remote.dto

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val forecast: List<Forecast>,
    val message: Int
)