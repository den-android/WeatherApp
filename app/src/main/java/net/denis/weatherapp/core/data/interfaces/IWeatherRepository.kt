package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.util.ErrorHandler
import net.denis.weatherapp.core.util.NetworkResult

interface IWeatherRepository {
    suspend fun fetchForecast(lat: Double, lon: Double): Flow<NetworkResult<WeatherDto>>
}