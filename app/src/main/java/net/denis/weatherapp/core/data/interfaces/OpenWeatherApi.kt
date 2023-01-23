package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface OpenWeatherApi {

    @GET("forecast")
    @Headers("Content-type: application/json")
    suspend fun getForecastMoscow(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String,
        @Query("appid") apiKey: String,
    ): Response<WeatherDto>
}