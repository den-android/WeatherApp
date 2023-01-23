package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.util.NetworkResult

interface IRemoteDatasource {

    suspend fun getForecastByCity(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String,
    ): NetworkResult<WeatherDto>
}