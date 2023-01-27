package net.denis.weatherapp.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.datasource.local.LocalDatasource
import net.denis.weatherapp.core.data.datasource.remote.RemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.features.core.Forecast
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val localDatasource: LocalDatasource,
    private val remoteDatasource: RemoteDatasource,
) : IWeatherRepository {

    override suspend fun getForecast(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String
    ): Flow<Forecast> {
        val response = remoteDatasource.getForecastByCity(lat, lon, exclude, apiKey)
        return flow {
            when (response) {
                is NetworkResult.Success -> {
                    emit(response.data.toForecast())
                }
                is NetworkResult.Error -> {

                }
                is NetworkResult.Exception -> {

                }
            }
        }
    }

}