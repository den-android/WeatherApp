package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.compose_items.CellWithText

@Composable
fun CityDetailWeatherScreen(
    vm: ForecastViewModel,
    currentCnt: Int,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.let { weatherItem ->
        DetailItems(weatherDto = weatherItem)
    }


}

@Composable
private fun DetailItems(
    modifier: Modifier = Modifier,
    weatherDto: WeatherDto,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            CellWithText()
            Spacer(modifier = modifier.width(16.dp))
            CellWithText()
        }
    }
}