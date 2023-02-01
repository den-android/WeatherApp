package net.denis.weatherapp.core.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.Resource
import net.denis.weatherapp.features.core.Forecast
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource,
) : IWeatherRepository {
    override suspend fun getForecast(
        lat: Double,
        lon: Double,
        apiKey: String
    ): Flow<Forecast> {
        val response = remoteDatasource.getForecastByCity(lat, lon, apiKey)

        return flow {
            when (response) {
                is NetworkResult.Success -> {
                    emit(response.data.toForecast())
                }
                is NetworkResult.Error -> {
                    Log.d("Logging", "err${response.code}\n")
                    emit(Forecast(error = "${response.code}", mainData = null, detailData = null))
                }
                is NetworkResult.Exception -> {
                    Log.d("Logging", "exc${response.e}")
                }
            }
        }

    }
}