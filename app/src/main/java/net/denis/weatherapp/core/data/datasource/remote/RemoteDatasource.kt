package net.denis.weatherapp.core.data.datasource.remote

import android.util.Log
import kotlinx.coroutines.delay
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.OpenWeatherApi
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.handleApi
import retrofit2.HttpException
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
) : IRemoteDatasource {

    override suspend fun getForecastByCity(
        lat: Double,
        lon: Double,
        apiKey: String,
    ): NetworkResult<WeatherDto> {
        return handleApi { openWeatherApi.getForecastMoscow(lat, lon, apiKey) }
    }

}