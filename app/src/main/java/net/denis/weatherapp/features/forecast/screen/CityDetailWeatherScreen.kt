package net.denis.weatherapp.features.forecast.screen

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.compose_items.CellWithIndicator
import net.denis.weatherapp.features.forecast.screen.components.compose_items.CellWithText
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CityDetailWeatherScreen(
    vm: ForecastViewModel,
    currentCnt: Int,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.weather

    weather?.let { items ->
        DetailItems(
            weatherDto = items,
            currentCnt = currentCnt,
        )

    }


}

@Composable
private fun DetailItems(
    modifier: Modifier = Modifier,
    weatherDto: WeatherDto,
    currentCnt: Int,
) {
    for (i in 0..weatherDto.cnt - 1) {
        if (currentCnt == weatherDto.list[i].dt) {
            val formattedSunrise = remember(String) {
                val sdf = SimpleDateFormat("HH:mm")
                val netDate = Date(weatherDto.city.sunrise.plus(10800).toLong() * 1000)
                sdf.format(netDate)
            }
            val formattedSunset = remember(String) {
                val sdf = SimpleDateFormat("HH:mm")
                val netDate = Date(weatherDto.city.sunset.plus(10800).toLong() * 1000)
                sdf.format(netDate)
            }
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(CityBackground),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top,
            ) {
                // Start Top item
                CellWithIndicator(
                    modifier = modifier
                        .weight(0.2f)
                        .fillMaxWidth(),
                    title = "Ветер",
                    indicatorValue = weatherDto.list[i].wind.speed.toFloat() / 10f
                )
                // End Top item

                // Start middle item
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                        .weight(0.4f)
                ) {
                    CellWithText(
                        title = "Рассвет",
                        text = formattedSunrise,
                        modifier = modifier
                            .weight(0.5f)
                    )
                    Spacer(modifier = modifier.padding(4.dp))
                    CellWithText(
                        title = "Закат",
                        text = formattedSunset,
                        modifier = modifier
                            .weight(0.5f)
                    )
                }
                // End middle item

                // Start bottom item
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(32.dp)
                        .weight(0.4f)

                ) {
                    CellWithText(
                        title = "Облачность",
                        text = "${weatherDto.list[i].clouds.all}%\nза последние 3 часа",
                        description = "${weatherDto.list[i].weather[0].description}",
                        modifier = modifier
                            .weight(0.5f)
                    )
                    Spacer(modifier = modifier.padding(4.dp))
                    CellWithIndicator(
                        title = "Видимость",
                        indicatorValue = weatherDto.list[i].visibility / 10000f,
                        modifier = modifier
                            .weight(0.5f)
                    )
                }
                // End bottom item
            }
        }
    }
}