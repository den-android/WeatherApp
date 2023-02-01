package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.City
import net.denis.weatherapp.features.forecast_at_three_hour.model.items.CityDetail

data class City(
    val coord: Coord,
    val country: String,
    val id: Int,
    val name: String,
    val population: Int,
    val sunrise: Int,
    val sunset: Int,
    val timezone: Int
) {
    fun toCity(): City {
        return City(
            name = name,
        )
    }

    fun toCityDetail(): CityDetail {
        return CityDetail(
            name = name,
            sunrise = sunrise,
            sunset = sunset,
        )
    }
}