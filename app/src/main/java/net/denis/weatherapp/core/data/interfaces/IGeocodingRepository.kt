package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto

interface IGeocodingRepository {
    suspend fun fetchNewCity(
        name: String
    ): Flow<GeocodingDto>

}