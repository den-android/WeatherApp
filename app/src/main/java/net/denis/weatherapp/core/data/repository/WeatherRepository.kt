package net.denis.weatherapp.core.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.getResult
import net.denis.weatherapp.core.util.handleApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource,
) : IWeatherRepository {
    override suspend fun fetchForecast(
        lat: Double,
        lon: Double,
    ): Flow<WeatherDto> {
        val response = remoteDatasource.fetchForecastByCoords(lat, lon)

        return flow {
            when (response) {
                is NetworkResult.Success -> {
                    getResult { emit(response.data) }
                }
                is NetworkResult.Error -> {
                    getResult { response.errorMessage }
                    //Log.d("Logging", "ERROR: ${response.errorMessage}\n")
                }

            }
        }

    }
}