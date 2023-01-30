package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.features.forecast.model.MeteorologyItem

@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    meteorologyItem: MeteorologyItem,
    onClick: (Int) -> Unit,
) {
    meteorologyItem?.forecastMain?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        forecastMain = weatherData,
                        meteorology = weatherData.meteorology[0],
                        main = weatherData.main,
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 16.dp)
                            .clickable { onClick(data.indexOf(weatherData)) },
                    )
                }
            }
        }
    }

}