package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.main_forecast.model.ForecastData

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
) {
    fun toForecastData(): ForecastData {
        return ForecastData(
            city = city,
            forecastList = list.map { it.toForecastItem() }
        )
    }

}