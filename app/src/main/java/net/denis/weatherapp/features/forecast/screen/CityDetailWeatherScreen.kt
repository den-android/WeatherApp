package net.denis.weatherapp.features.forecast.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel

@Composable
fun CityDetailWeatherScreen(
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

}