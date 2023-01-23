package net.denis.weatherapp.core.data.datasource.remote.dto

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)