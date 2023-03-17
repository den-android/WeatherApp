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
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.model.CityData
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

    override suspend fun writeDetailParams(detailData: DetailData) {
        withContext(scopeIo.coroutineContext) {
            localDatasource.writeDetailParams(detailData = detailData)
        }
    }

    override suspend fun readDetailParams(): DetailData {
        return withContext(scopeIo.coroutineContext) {
            return@withContext localDatasource.readDetailParams()
        }
    }

    override suspend fun readCityCoords(): CityData {
        return withContext(scopeIo.coroutineContext) {
            return@withContext localDatasource.readCityCoords()
        }
    }

}

