package net.denis.weatherapp.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.util.ErrorHandler
import net.denis.weatherapp.core.util.NetworkResult
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource,
) : IWeatherRepository {

    override suspend fun fetchForecast(lat: Double, lon: Double): Flow<NetworkResult<WeatherDto>> {
        val response = remoteDatasource.fetchForecastByCoords(lat = lat, lon = lon)
        return flow {
            emit(value = response)
        }
    }

}