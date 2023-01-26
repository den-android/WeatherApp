package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.Main

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
) {
    fun toMain(): Main {
        return Main(
            temp = temp
        )
    }
}