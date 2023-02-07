package net.denis.weatherapp.features.fetch_new_city.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CityData(
    val name: @RawValue String,
    val lat: @RawValue Double,
    val lon: @RawValue Double,
): Parcelable
