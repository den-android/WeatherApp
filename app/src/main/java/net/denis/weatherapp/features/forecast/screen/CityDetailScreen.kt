package net.denis.weatherapp.features.forecast.screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import net.denis.weatherapp.features.forecast.model.forecastItem
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay

@Composable
fun CityDetailScreen(
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.let {
        CurrentWeatherInfoDisplay(
            city = it.city.name,
            temp = it.list.get(0).main.temp,
            weatherDesc = it.list.get(0).weather.get(0).description,
            currentDateTime = it.list.get(0).dt_txt,
            weatherIcon = it.list.get(0).weather.get(0).id
        )
    } ?: CurrentWeatherInfoDisplay(
        city = "not",
        temp = 0.0,
        weatherDesc = "ni",
        currentDateTime = "0:0:0",
        weatherIcon = 1
    )

}