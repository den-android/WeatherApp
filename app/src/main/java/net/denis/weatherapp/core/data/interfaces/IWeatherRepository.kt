package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.util.network.NetworkResult
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.model.CityData

interface IWeatherRepository {
    suspend fun fetchForecast(lat: Double, lon: Double): Flow<NetworkResult<WeatherDto>>

    suspend fun putData(params: Any?)

    suspend fun getData(): Any?

}