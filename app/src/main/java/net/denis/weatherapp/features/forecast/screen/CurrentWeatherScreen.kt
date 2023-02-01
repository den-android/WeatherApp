package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.ShimmerListItem
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastState
import net.denis.weatherapp.features.forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    weatherState: State<ForecastState>,
) {
    val itemWeather = weatherState.value.forecastData
    val isLoading = weatherState.value.isLoading

    ShimmerListItem(
        isLoading = isLoading,
        contentAfterLoading = {
            itemWeather?.let { itemWeather ->
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(color = CityBackground)
                ) {

                    Box(modifier = modifier.weight(3f)) {

                        CurrentWeatherInfoDisplay(
                            city = itemWeather.city.name,
                            temp = itemWeather.forecastItem[0].main.temp,
                            weatherDesc = itemWeather.forecastItem[0].meteorology[0].description,
                            currentDateTime = "213",
                            weatherIcon = itemWeather.forecastItem[0].meteorology[0].id
                        )
                    }

                    Box(modifier = modifier.weight(1f),) {
                        WeatherForecastDisplay(
                            forecastData = itemWeather,
                            onClick = {
                                navController.navigate(
                                    route = Screen.DetailForecastScreen.passDetailCnt(
                                        cnt = it
                                    )
                                )
                            }
                        )
                    }

                    BottomNavigateMenu(
                        onFabClicked = {
                            navController.navigate(
                                route = Screen.SearchCityScreen.passQuery(
                                    city = it
                                )
                            )
                        }
                    )
                }
            }

        })

}