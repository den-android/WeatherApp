package net.denis.weatherapp.features.main_forecast.model

import net.denis.weatherapp.features.detail_forecast.model.SunDetail

data class ForecastData(
    val sunDetail: SunDetail,
    val forecastList: List<ForecastItem>,
)