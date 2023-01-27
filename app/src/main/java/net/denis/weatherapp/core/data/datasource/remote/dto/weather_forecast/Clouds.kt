package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast_at_three_hour.model.Cloud

data class Clouds(
    val all: Int
) {
    fun toClouds(): Cloud {
        return Cloud(
            all = all
        )
    }
}