package net.denis.weatherapp.core.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.data.interfaces.IGeocodingRepository
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.util.network.NetworkResult
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import javax.inject.Inject

class GeocodingRepository @Inject constructor(
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource,
) : IGeocodingRepository {

    override suspend fun fetchNewCity(name: String): Flow<NetworkResult<GeocodingDto>> {
        val response = remoteDatasource.fetchCity(name)
        return flow {
            emit(value = response)
        }
    }

    override suspend fun writeCityCoords(cityData: CityData) {
        localDatasource.writeCityCoords(cityData = cityData)
    }

}