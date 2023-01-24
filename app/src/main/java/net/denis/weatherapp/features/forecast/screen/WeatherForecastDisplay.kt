package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel

@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.list?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow(content = {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp),
                        list = weatherData,
                        weather = weatherData.weather[0],
                        main = weatherData.main,
                    )
                }
            })
        }
    }


}