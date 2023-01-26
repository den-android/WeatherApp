package net.denis.weatherapp.features.forecast.model

data class MeteorologyItem(
    val city: City,
    val forecast: List<Forecast>,
)