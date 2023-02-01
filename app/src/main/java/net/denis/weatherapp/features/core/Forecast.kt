package net.denis.weatherapp.features.core

import net.denis.weatherapp.features.forecast.model.ForecastData
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData

data class Forecast(
    val mainData: ForecastData,
    val detailData: DetailData,
)
