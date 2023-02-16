package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.util.NetworkResult

interface IRemoteDatasource {
    suspend fun fetchForecastByCoords(lat: Double, lon: Double): NetworkResult<WeatherDto>
    suspend fun fetchCity(name: String): NetworkResult<GeocodingDto>
}