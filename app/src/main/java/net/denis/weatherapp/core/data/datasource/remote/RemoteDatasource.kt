package net.denis.weatherapp.core.data.datasource.remote

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.OpenWeatherApi
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.handleApi
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
) : IRemoteDatasource {

    override suspend fun getForecastByCity(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String,
    ): NetworkResult<WeatherDto> {
        return handleApi { openWeatherApi.getForecastMoscow(lat,lon,exclude,apiKey) }
    }

}