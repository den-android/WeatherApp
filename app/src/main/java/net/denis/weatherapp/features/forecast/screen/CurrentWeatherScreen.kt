package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun CurrentWeatherScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    weather: MeteorologyItem
) {
    weather?.let { itemWeather ->
        itemWeather.forecastMain.forEach { forecastMainItem ->
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .background(color = CityBackground)
            ) {
                Box(
                    modifier = modifier.weight(3f)
                ) {
                    val formattedTime = remember(forecastMainItem.dt) {
                        val sdf = SimpleDateFormat("HH:mm")
                        val netDate = Date(forecastMainItem.dt.toLong() * 1000)
                        sdf.format(netDate)
                    }
                    CurrentWeatherInfoDisplay(
                        city = itemWeather.city.name,
                        temp = forecastMainItem.main.temp,
                        weatherDesc = forecastMainItem.meteorology.get(0).description,
                        currentDateTime = formattedTime,
                        weatherIcon = forecastMainItem.meteorology.get(0).id
                    )
                }
                Box(
                    modifier = modifier.weight(1f),
                ) {
                    WeatherForecastDisplay(
                        meteorologyItem = itemWeather,
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
                            route = Screen.SearchCityScreen.passQuerry(
                                city = it
                            )
                        )
                    }
                )
            }
        }
    }


}