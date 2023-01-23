package net.denis.weatherapp.core.data.interfaces

import retrofit2.Response
import retrofit2.http.GET

interface OpenWeatherApi {

    @GET("")
    suspend fun getWeather(): Response<WeatherDto>

}