package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
)