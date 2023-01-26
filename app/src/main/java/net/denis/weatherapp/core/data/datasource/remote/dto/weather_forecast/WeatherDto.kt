package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.MeteorologyItem

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
) {
    fun toWeatherItem(): MeteorologyItem {
        return MeteorologyItem(
            city = city.toCity(),
            forecast = list.map { it.toForecast() }
        )
    }
}