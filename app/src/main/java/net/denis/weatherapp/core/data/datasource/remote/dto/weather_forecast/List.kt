package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.ForecastMain
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
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
    fun toForecast(): ForecastMain {
        return ForecastMain(
            dt = dt,
            main = main.toMain(),
            meteorology = weather.map { it.toWeather() },
        )
    }

    fun toDetailItem(): Detail {
        return Detail(
            cloud = clouds.toClouds(),
            wind = wind.toWind(),
            visibility = visibility,
            cityDetail =
        )
    }
}