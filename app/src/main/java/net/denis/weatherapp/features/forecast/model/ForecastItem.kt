package net.denis.weatherapp.features.forecast.model

import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData

data class ForecastItem(
    val dateTime: String,
    val temp: String,
    val meteorology: List<Meteorology>,
    val detailData: DetailData,
)