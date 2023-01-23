package net.denis.weatherapp.core.data.repository

import net.denis.weatherapp.core.data.datasource.local.LocalDatasource
import net.denis.weatherapp.core.data.datasource.remote.RemoteDatasource
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDatasource: RemoteDatasource,
): IWeatherRepository {

    override suspend fun getForecast(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String
    ): WeatherDto {
        TODO("Not yet implemented")
    }
}