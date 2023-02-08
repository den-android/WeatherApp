package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep
import net.denis.weatherapp.features.main_forecast.model.Meteorology

@Keep
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

fun Weather.toMeteorology() = Meteorology(
    id = id,
    description = description,
)