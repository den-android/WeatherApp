package net.denis.weatherapp.features.main_forecast.model

import net.denis.weatherapp.features.detail_forecast.model.CityDetail

data class ForecastData(
    val cityDetail: CityDetail,
    val forecastList: List<ForecastItem>,
)