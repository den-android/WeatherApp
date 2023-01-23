package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)