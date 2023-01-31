package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.core.util.Resource
import net.denis.weatherapp.features.core.Forecast

interface IWeatherRepository {
    suspend fun getForecast(
        lat: Double,
        lon: Double,
        apiKey: String,
    ): Flow<Forecast>
}