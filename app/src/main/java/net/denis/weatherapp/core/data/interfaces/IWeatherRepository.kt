package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.features.forecast.model.MeteorologyItem

interface IWeatherRepository {
    suspend fun getForecast(
        lat: Double,
        lon: Double,
        exclude: String,
        apiKey: String,
    ): Flow<MeteorologyItem>

}