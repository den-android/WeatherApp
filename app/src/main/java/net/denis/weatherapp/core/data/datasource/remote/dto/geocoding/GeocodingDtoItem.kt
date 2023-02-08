package net.denis.weatherapp.core.data.datasource.remote.dto.geocoding

import androidx.annotation.Keep
import net.denis.weatherapp.features.fetch_new_city.model.CityData

@Keep
data class GeocodingDtoItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)

fun GeocodingDtoItem.toRuCity() = CityData(
    name = local_names.ru,
    lat = lat,
    lon = lon,
)
fun GeocodingDtoItem.toEnCity() = CityData(
    name = name,
    lat = lat,
    lon = lon,
)