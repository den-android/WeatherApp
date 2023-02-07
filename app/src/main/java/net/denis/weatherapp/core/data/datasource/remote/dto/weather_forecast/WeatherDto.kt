package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import com.google.gson.annotations.SerializedName
import net.denis.weatherapp.features.main_forecast.model.ForecastData

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    @SerializedName("list")
    val forecast: List<Forecast>,
    val message: Int
)

fun WeatherDto.toForecastData() = ForecastData(
    city = city,
    forecastList = forecast.map { it.toForecastItem() }
)