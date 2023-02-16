package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.util.Constants.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OpenWeatherApi {

    @GET("forecast?lang=ru&units=metric&cnt=7&exclude=alerts&appid=${API_KEY}")
    @Headers("Content-type: application/json")
    suspend fun fetchForecastByCity(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
    ): Response<WeatherDto>

}