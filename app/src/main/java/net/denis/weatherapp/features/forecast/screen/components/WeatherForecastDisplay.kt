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
import net.denis.weatherapp.features.forecast.model.ForecastData

@Composable
fun WeatherForecastDisplay(
    modifier: Modifier = Modifier,
    forecastData: ForecastData,
    onClick: (Int) -> Unit,
) {
    forecastData?.forecastItem?.let { data ->
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            LazyRow {
                items(data) { weatherData ->
                    HourlyWeatherDisplay(
                        forecastItem = weatherData,
                        meteorology = weatherData.meteorology,
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