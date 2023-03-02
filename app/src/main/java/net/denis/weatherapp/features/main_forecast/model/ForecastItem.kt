package net.denis.weatherapp.features.main_forecast.model

import androidx.annotation.Keep
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import java.text.SimpleDateFormat
import java.util.*

@Keep
data class ForecastItem(
    val dateTime: String,
    val meteorology: List<Meteorology>,
    val temp: String,
)