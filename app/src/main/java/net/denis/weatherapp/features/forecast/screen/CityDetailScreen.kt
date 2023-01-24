package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay

@Composable
fun CityDetailScreen(
    modifier: Modifier = Modifier,
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.let {
        Column(modifier = modifier
            .fillMaxSize()
            .background(color = CityBackground)) {
            Box(
                modifier = modifier.weight(3f)
            ) {
                CurrentWeatherInfoDisplay(
                    city = it.city.name,
                    temp = it.list.get(0).main.temp,
                    weatherDesc = it.list.get(0).weather.get(0).description,
                    currentDateTime = it.list.get(0).dt_txt,
                    weatherIcon = it.list.get(0).weather.get(0).id
                ) ?: CurrentWeatherInfoDisplay(
                    city = "not",
                    temp = 0.0,
                    weatherDesc = "ni",
                    currentDateTime = "0:0:0",
                    weatherIcon = 1
                )
            }
            Box(
                modifier = modifier.weight(1f)
            ) {
                WeatherForecastDisplay(vm = vm)
            }

        }
    }

}