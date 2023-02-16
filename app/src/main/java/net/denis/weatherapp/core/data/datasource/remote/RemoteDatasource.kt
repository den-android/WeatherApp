package net.denis.weatherapp.core.data.datasource.remote

import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.GeocodingApi
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.OpenWeatherApi
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.handleApi
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
    private val geocodingApi: GeocodingApi,
) : IRemoteDatasource {

    override suspend fun fetchForecastByCoords(lat: Double, lon: Double): NetworkResult<WeatherDto> {
        return handleApi { openWeatherApi.fetchForecastByCity(lat = lat, lon = lon) }
    }

    override suspend fun fetchCity(name: String): NetworkResult<GeocodingDto> {
        return handleApi { geocodingApi.fetchCity(name = name) }
    }

}