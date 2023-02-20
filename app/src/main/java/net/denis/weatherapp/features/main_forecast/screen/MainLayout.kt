package net.denis.weatherapp.features.main_forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay

@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = CityBackground)
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(modifier.height(160.dp))
        }
        state.forecastData?.forecastList?.let { itemForecast ->
            Box(modifier = modifier.weight(3f)) {
                CurrentWeatherDisplay(
                    city = state.forecastData.cityDetail.cityName,
                    weatherIcon = itemForecast[0].meteorology[0].id,
                    temp = itemForecast[0].temp,
                    weatherDesc = itemForecast[0].meteorology[0].description,
                    currentDateTime = itemForecast[0].dateTime
                )
            }

            Box(modifier = modifier.weight(1f)) {
                WeatherForecastDisplay(
                    forecastData = state.forecastData,
                    onClick = {
                        navController.navigate(
                            route = Screen.DetailScreen.passDetailPosition(it)
                        )
                    }
                )
            }
        }
        BottomNavigateMenu(onFabClicked = {
            navController.navigate(
                route = Screen.FetchCityScreen.route
            )
        })
    }
}