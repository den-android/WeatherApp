package net.denis.weatherapp.features.forecast.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay

@Composable
fun CityDetailScreen(
    vm: ForecastViewModel,
    
) {

    val state = vm.viewState.collectAsState()

    CurrentWeatherInfoDisplay(
        city = "",
        temp = "",
        weather = "",
        weatherIcon = 1
    )
}
