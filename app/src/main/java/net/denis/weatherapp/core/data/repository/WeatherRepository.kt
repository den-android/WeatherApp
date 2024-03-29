package net.denis.weatherapp.core.data.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.util.network.NetworkResult
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val scopeIo: CoroutineScope,
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource
) : IWeatherRepository {

    override suspend fun fetchForecast(lat: Double, lon: Double): Flow<NetworkResult<WeatherDto>> =
        withContext(scopeIo.coroutineContext) {
            val response = remoteDatasource.fetchForecastByCoords(lat = lat, lon = lon)
            return@withContext flow {
                emit(value = response)
            }
        }

    override suspend fun putData(params: Any?) {
        withContext(scopeIo.coroutineContext) {
            localDatasource.putData(params = params)
        }
    }

    override suspend fun getData(): Any? {
        return withContext(scopeIo.coroutineContext) {
            localDatasource.getData()
        }
    }
}

