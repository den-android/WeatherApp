package net.denis.weatherapp.core.util

import net.denis.weatherapp.features.fetch_new_city.model.CityData

object Constants {
    const val API_KEY = "b05865d24d90b1dbccfb3ced2627b4e9"
    private const val DEFAULT_LAT = 47.2213858
    private const val DEFAULT_LON = 39.7114196
    val DEFAULT_CITY = CityData(name = "Ростов на Дону", lat = DEFAULT_LAT, lon = DEFAULT_LON)
}