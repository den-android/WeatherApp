package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.ShimmerListItem
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay

@Composable
fun ForecastWeatherScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val forecastData = state.value.forecastData

    forecastData?.forecastItem?.let { itemForecast ->
        ShimmerListItem(
            isLoading = state.value.isLoading,
            contentAfterLoading = {
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(color = CityBackground)
                ) {
                    Box(modifier = modifier.weight(3f)) {
                        CurrentWeatherInfoDisplay(
                            city = forecastData.city.name,
                            weatherIcon = itemForecast[0].meteorology[0].id,
                            temp = itemForecast[0].temp,
                            weatherDesc = itemForecast[0].meteorology[0].description,
                            currentDateTime = itemForecast[0].dateTime
                        )
                    }

                    Box(modifier = modifier.weight(1f)) {
                        WeatherForecastDisplay(
                            forecastData = forecastData,
                            onClick = {
                                navController.navigate(
                                    route = Screen.DetailForecastScreen.passDetailId(
                                        id = it
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
            })
    }
}