package net.denis.weatherapp.features.forecast.screen

import androidx.compose.runtime.Composable
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay

@Composable
fun CityDetailScreen(
    vm: ForecastViewModel,

    ) {
    CurrentWeatherInfoDisplay(
        city =,
        temp =,
        weather =,
        weatherIcon =
    )
}
