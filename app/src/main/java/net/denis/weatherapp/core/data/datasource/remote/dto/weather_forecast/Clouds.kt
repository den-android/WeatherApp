package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.Clouds

data class Clouds(
    val all: Int
) {
    fun toClouds(): Clouds {
        return Clouds(
            all = all
        )
    }
}