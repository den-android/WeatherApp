package net.denis.weatherapp.features.fetch_new_city.model

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class CityData(
    val name: String,
    val lat: Double,
    val lon: Double
)