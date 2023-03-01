package net.denis.weatherapp.features.main_forecast.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.HourlyModelCard

@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    hourlyList: List<HourlyModelCard>,
    onClick: (Int) -> Unit,
) {
    hourlyList?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow(
                modifier = modifier
                    .padding(horizontal = 16.dp),
            ) {
                items(data) { hourlyItem ->

                    when (hourlyItem) {
                        is HourlyModelCard.CurrentHourlyCard -> {
                            CurrentHourlyWeatherDisplay(
                                hourlyItem = hourlyItem.hourlyItem,
                                onRangeClicked = { onClick(data.indexOf(hourlyItem)) }
                            )
                        }

                        is HourlyModelCard.HourlyCard -> {
                            HourlyWeatherDisplay(
                                hourlyItem = hourlyItem.hourlyItem,
                                onRangeClicked = { onClick(data.indexOf(hourlyItem)) }
                            )
                        }
                    }

                }
            }
        }
    }

}