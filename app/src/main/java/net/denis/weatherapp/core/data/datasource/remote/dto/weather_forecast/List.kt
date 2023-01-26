package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.Forecast
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
) {
    fun toForecast(): Forecast {
        return Forecast(
            clouds = clouds.toClouds(),
            dt = dt,
            main = main.toMain(),
            visibility = visibility,
            meteorology = weather.map { it.toWeather() },
            wind = wind.toWind(),
        )
    }
}