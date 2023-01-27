package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast_at_three_hour.model.Wind

data class Wind(
    val deg: Int,
    val gust: Double,
    val speed: Double
){
    fun toWind(): Wind {
        return Wind(
            speed = speed
        )
    }
}