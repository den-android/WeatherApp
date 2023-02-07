package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import com.google.gson.annotations.SerializedName

data class DayOrNight(
    @SerializedName("pod")
    val dayOrNight: String
)