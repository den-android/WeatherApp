package net.denis.weatherapp.features.forecast.model

import net.denis.weatherapp.features.forecast_at_three_hour.model.items.CityDetail

data class ForecastData(
    val city: CityDetail,
    val forecastItem: List<ForecastItem>,
)