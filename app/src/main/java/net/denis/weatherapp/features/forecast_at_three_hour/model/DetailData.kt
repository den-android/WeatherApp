package net.denis.weatherapp.features.forecast_at_three_hour.model

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City
import net.denis.weatherapp.core.util.MultipleView

data class DetailData(
    val detailItem: List<DetailItem>,
)