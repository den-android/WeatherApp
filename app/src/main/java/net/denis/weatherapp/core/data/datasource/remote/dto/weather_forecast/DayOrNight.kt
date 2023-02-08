package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DayOrNight(
    @SerializedName("pod")
    val dayOrNight: String
)