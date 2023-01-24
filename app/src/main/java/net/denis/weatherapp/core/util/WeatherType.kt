package net.denis.weatherapp.core.util

import androidx.annotation.DrawableRes
import net.denis.weatherapp.R

sealed class WeatherType(
    @DrawableRes val iconRes: Int
) {

    // Clear
    object ClearSky : WeatherType(
        iconRes = R.drawable.ic_sunny
    )

    // Clouds
    object FewClouds : WeatherType(
        iconRes = R.drawable.ic_sunnycloudy
    )

    object ScatteredClouds : WeatherType(
        iconRes = R.drawable.ic_cloudy
    )

    object BrokenClouds : WeatherType(
        iconRes = R.drawable.ic_cloudy
    )

    object OvercastClouds : WeatherType(
        iconRes = R.drawable.ic_very_cloudy
    )

    // Thunderstorm

    object Thunderstorm200 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm201 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm202 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm210 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm211 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm212 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm221 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm230 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm231 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    object Thunderstorm232 : WeatherType(
        iconRes = R.drawable.ic_thunder
    )

    // Drizzle
    object Drizzle300 : WeatherType(
        iconRes = R.drawable.ic_sunnyrainy
    )

    object Drizzle301 : WeatherType(
        iconRes = R.drawable.ic_sunnyrainy
    )

    object Drizzle302 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle310 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle311 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle312 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle313 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle314 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    object Drizzle321 : WeatherType(
        iconRes = R.drawable.ic_rainy
    )

    // Rain
    object Rain500 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain501 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain502 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain503 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain504 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain511 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain520 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain521 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain522 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Rain531 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    // Snow
    object Show600 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show601 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show602 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show611 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show612 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show613 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show615 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show616 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show620 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show621 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )

    object Show622 : WeatherType(
        iconRes = R.drawable.ic_rainshower
    )


    //Testing
    object TestIcon : WeatherType(
        iconRes = R.drawable.ic_launcher_foreground
    )

    companion object {
        fun fromWMO(code: Int): WeatherType {
            return when (code) {
                200 -> Thunderstorm200
                201 -> Thunderstorm201
                202 -> Thunderstorm202
                210 -> Thunderstorm210
                211 -> Thunderstorm211
                212 -> Thunderstorm212
                221 -> Thunderstorm221
                230 -> Thunderstorm230
                231 -> Thunderstorm231
                232 -> Thunderstorm232
                300 -> Drizzle300
                301 -> Drizzle301
                302 -> Drizzle302
                310 -> Drizzle310
                311 -> Drizzle311
                312 -> Drizzle312
                313 -> Drizzle313
                314 -> Drizzle314
                321 -> Drizzle321
                500 -> Rain500
                501 -> Rain501
                502 -> Rain502
                503 -> Rain503
                504 -> Rain504
                511 -> Rain511
                520 -> Rain520
                521 -> Rain521
                522 -> Rain522
                531 -> Rain531
                600 -> Show600
                601 -> Show601
                602 -> Show602
                611 -> Show611
                612 -> Show612
                613 -> Show613
                615 -> Show615
                616 -> Show616
                620 -> Show620
                621 -> Show621
                622 -> Show622
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