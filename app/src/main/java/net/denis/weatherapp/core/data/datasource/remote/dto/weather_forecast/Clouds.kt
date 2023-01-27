package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast_at_three_hour.model.Clouds

data class Clouds(
    val all: Int
) {
    fun toClouds(): Clouds {
        return Clouds(
            all = all
        )
    }
}