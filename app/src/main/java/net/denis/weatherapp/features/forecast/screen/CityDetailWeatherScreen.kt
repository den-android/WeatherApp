package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Clouds
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.CellWithIndicator

@Composable
fun CityDetailWeatherScreen(
    vm: ForecastViewModel,
    currentCnt: Int,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.let { weatherItem ->
        if (currentCnt == weatherItem.cnt) {
            DetailItems(
                cloud = weatherItem.list[1].clouds,
                visibility = weather.list[1].visibility,
            )
        }
    }
}

@Composable
private fun DetailItems(
    modifier: Modifier = Modifier,
    cloud: Clouds,
    visibility: Int
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground)
    ) {
        Row(
            modifier = modifier.fillMaxWidth()
        ) {
            Box(modifier = modifier.weight(1f)) {
                CellWithIndicator(
                    title = "ОБЛАЧНОСТЬ",
                    indicatorValue = cloud.all / 100f
                )
            }
            Spacer(modifier = modifier.width(16.dp))
            Box(modifier = modifier.weight(1f)) {
                CellWithIndicator(
                    title = "ВИДИМОСТЬ",
                    indicatorValue = visibility / 10000f
                )
            }
        }
    }
}