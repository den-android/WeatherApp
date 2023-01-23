package net.denis.weatherapp.core.data.datasource.remote.dto.geocoding

data class GeocodingDtoItem(
    val country: String,
    val lat: Double,
    val local_names: LocalNames,
    val lon: Double,
    val name: String,
    val state: String
)