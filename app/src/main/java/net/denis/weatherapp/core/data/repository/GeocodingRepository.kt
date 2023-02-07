package net.denis.weatherapp.core.data.repository

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import net.denis.weatherapp.core.data.datasource.local.LocalDatasource
import net.denis.weatherapp.core.data.datasource.remote.RemoteDatasource
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.data.interfaces.IGeocodingRepository
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.util.NetworkResult
import javax.inject.Inject

class GeocodingRepository @Inject constructor(
    private val localDatasource: ILocalDatasource,
    private val remoteDatasource: IRemoteDatasource,
): IGeocodingRepository {
    override suspend fun fetchNewCity(name: String): Flow<GeocodingDto> {
        val response = remoteDatasource.fetchCity(name)
        return flow {
            when (response) {
                is NetworkResult.Success -> {
                    emit(response.data)
                }
                is NetworkResult.Error -> {
                    Log.d("Logging", "ERROR: ${response.message}")
                }
            }
        }
    }
}