package net.denis.weatherapp.features.main_forecast.model

import net.denis.weatherapp.features.detail_forecast.model.SunDetail
import net.denis.weatherapp.features.detail_forecast.model.DetailData

data class ForecastItem(
    val dateTime: String,
    val meteorology: List<Meteorology>,
    val temp: String,
    val detailData: DetailData,
)