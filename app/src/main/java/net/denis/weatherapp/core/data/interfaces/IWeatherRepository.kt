package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto

interface IWeatherRepository {
    suspend fun getForecast(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String,
    ): WeatherDto
}