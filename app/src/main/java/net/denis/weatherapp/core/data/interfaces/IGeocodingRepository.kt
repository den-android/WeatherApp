package net.denis.weatherapp.core.data.interfaces

import kotlinx.coroutines.flow.Flow
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.util.network.NetworkResult
import net.denis.weatherapp.features.fetch_new_city.model.CityData

interface IGeocodingRepository {
    suspend fun fetchNewCity(name: String): Flow<NetworkResult<GeocodingDto>>

    suspend fun writeCityCoords(cityData: CityData)
}