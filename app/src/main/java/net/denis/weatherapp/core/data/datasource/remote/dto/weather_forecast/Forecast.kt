package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class Forecast(
    val clouds: Clouds,
    @SerializedName("dt")
    val dateTime: Int,
    @SerializedName("dt_txt")
    val dateTime_txt: String,
    val main: Main,
    @SerializedName("pop")
    val precipitation: Double,
    @SerializedName("sys")
    val dayOrNight: DayOrNight,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)