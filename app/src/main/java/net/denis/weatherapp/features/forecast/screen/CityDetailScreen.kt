package net.denis.weatherapp.features.forecast.screen

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay
import java.util.*

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
                val formattedTime = remember(it.list.get(0).dt) {
                    val sdf = SimpleDateFormat("HH:mm")
                    val netDate = Date(it.list.get(0).dt.toLong()*1000)
                    sdf.format(netDate)
                }
                CurrentWeatherInfoDisplay(
                    city = it.city.name,
                    temp = it.list.get(0).main.temp,
                    weatherDesc = it.list.get(0).weather.get(0).description,
                    currentDateTime = formattedTime,
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