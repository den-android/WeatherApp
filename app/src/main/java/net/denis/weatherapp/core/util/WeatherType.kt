package net.denis.weatherapp.core.util

import androidx.annotation.DrawableRes
import net.denis.weatherapp.R

sealed class WeatherType(
    val weatherDesc: String,
    @DrawableRes val iconRes: Int
) {

    // Clear
    object ClearSky : WeatherType(
        weatherDesc = "Clear sky",
        iconRes = R.drawable.ic_sunny
    )

    // Clouds
    object FewClouds : WeatherType(
        weatherDesc = "few clouds: 11-25%",
        iconRes = R.drawable.ic_cloudy
    )

    object ScatteredClouds : WeatherType(
        weatherDesc = "scattered clouds: 25-50%",
        iconRes = R.drawable.ic_cloudy
    )

    object BrokenClouds : WeatherType(
        weatherDesc = "broken clouds: 51-84%",
        iconRes = R.drawable.ic_very_cloudy
    )

    object OvercastClouds : WeatherType(
        weatherDesc = "overcast clouds: 85-100%",
        iconRes = R.drawable.ic_very_cloudy
    )

    //Testing
    object TestIcon : WeatherType(
        weatherDesc = "",
        iconRes = R.drawable.ic_launcher_foreground
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                800 -> ClearSky
                801 -> FewClouds
                802 -> ScatteredClouds
                803 -> BrokenClouds
                804 -> OvercastClouds
                else -> TestIcon
            }
        }
    }
}