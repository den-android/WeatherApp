package net.denis.weatherapp.features.main_forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.util.Constants.PARAM_DETAIL_SCREEN
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: MainViewModel,
) {
    val state = vm.viewState.collectAsState()
    val forecastState = state.value.forecastData

    forecastState?.forecastList?.let { itemForecast ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = CityBackground)
        ) {
            Box(modifier = modifier.weight(3f)) {
                CurrentWeatherDisplay(
                    city = forecastState.city.name,
                    weatherIcon = itemForecast[0].meteorology[0].id,
                    temp = itemForecast[0].temp,
                    weatherDesc = itemForecast[0].meteorology[0].description,
                    currentDateTime = itemForecast[0].dateTime
                )
            }

            Box(modifier = modifier.weight(1f)) {
                WeatherForecastDisplay(
                    forecastData = forecastState,
                    onClick = {
                        navController.currentBackStackEntry?.savedStateHandle?.set(
                            key = PARAM_DETAIL_SCREEN,
                            value = itemForecast[it].detailData
                        )
                        navController.navigate(
                            route = Screen.DetailForecastScreen.route
                        )
                    }
                )
            }

            BottomNavigateMenu(onFabClicked = {})
        }
    }
}