package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.GeocodingDto
import net.denis.weatherapp.core.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GeocodingApi {

    @GET("direct?q=name,ru&limit=1&appid=${API_KEY}")
    @Headers("Content-type: application/json")
    suspend fun fetchCity(
        @Query("city name") name: String,
    ) : Response<GeocodingDto>
}