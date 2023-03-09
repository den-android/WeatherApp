package net.denis.weatherapp.features.current_forecast.screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.features.current_forecast.model.HourlyItem
import net.denis.weatherapp.features.current_forecast.model.HourlyModelCard

@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    hourlyList: List<HourlyModelCard>,
    onClick: (HourlyItem) -> Unit,
) {
    hourlyList?.let { hourlyItem ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow {
                items(hourlyItem) { item ->
                    Box(
                        modifier = modifier
                            .padding(start = 16.dp, end = 16.dp)
                    ) {
                        when (item) {
                            is HourlyModelCard.CurrentHourlyCard -> {
                                CurrentHourlyWeatherDisplay(
                                    hourlyItem = item.hourlyItem,
                                    onRangeClicked = { onClick(item.hourlyItem) }
                                )
                            }

                            is HourlyModelCard.HourlyCard -> {
                                HourlyWeatherDisplay(
                                    hourlyItem = item.hourlyItem,
                                    onRangeClicked = { onClick(item.hourlyItem) }
                                )
                            }
                        }
                    }


                }
            }
        }
    }

}