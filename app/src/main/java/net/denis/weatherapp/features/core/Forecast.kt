package net.denis.weatherapp.features.core

import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData

data class Forecast(
    val mainData: MeteorologyItem?,
    val detailData: DetailData?,
    val error: String?= null,
)
