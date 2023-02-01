package net.denis.weatherapp.features.forecast_at_three_hour.model.items

data class CityDetail(
    val name: String,
    val sunrise: Int,
    val sunset: Int,
)