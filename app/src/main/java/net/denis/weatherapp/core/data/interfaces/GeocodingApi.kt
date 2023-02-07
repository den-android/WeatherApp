package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.*

interface GeocodingApi {

    @GET("direct")
    @Headers("Content-type: application/json")
    suspend fun fetchCity(
        @Query("q") name: String,
        @Query("limit") limit: Int = 1,
        @Query("appid") appid: String = API_KEY,
    ): Response<GeocodingDto>
}