package net.denis.weatherapp.features.current_forecast.model

import androidx.annotation.Keep
import net.denis.weatherapp.features.detail_forecast.model.DetailData

@Keep
data class HourlyItem(
    val dateTime: String,
    val meteorology: List<Meteorology>,
    val temp: String,
    val detailData: DetailData,
)