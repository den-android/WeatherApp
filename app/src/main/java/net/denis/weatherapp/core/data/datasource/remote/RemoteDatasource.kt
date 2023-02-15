package net.denis.weatherapp.core.data.datasource.remote

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.data.interfaces.GeocodingApi
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.OpenWeatherApi
import net.denis.weatherapp.core.util.NetworkResult
import net.denis.weatherapp.core.util.getResult
import net.denis.weatherapp.core.util.handleApi
import retrofit2.Response
import javax.inject.Inject

class RemoteDatasource @Inject constructor(
    private val openWeatherApi: OpenWeatherApi,
    private val geocodingApi: GeocodingApi,
) : IRemoteDatasource {

    override suspend fun fetchForecastByCoords(lat: Double, lon: Double): Result<WeatherDto> {
        val response = handleApi { openWeatherApi.fetchForecastByCity(lat, lon) }
        return when (response) {
            is NetworkResult.Success -> {
                getResult { response.data }
            }

            is NetworkResult.Error -> {
                getResult { response.message }
                //Log.d("Logging", "ERROR: ${response.errorMessage}\n")
            }

            is NetworkResult.Exception -> {
                getResult { response.e.localizedMessage }
                Log.d("App crash", "${response.e.localizedMessage}")
            }
        }
    }

    override suspend fun fetchCity(name: String): NetworkResult<GeocodingDto> {
        return handleApi { geocodingApi.fetchCity(name) }
    }

}