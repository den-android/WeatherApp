package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.Meteorology

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
){
    fun toWeather(): Meteorology {
        return Meteorology(
            id = id,
            description = description
        )
    }
}