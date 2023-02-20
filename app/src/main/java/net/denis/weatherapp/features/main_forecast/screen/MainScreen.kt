package net.denis.weatherapp.features.main_forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: MainViewModel = viewModel(),
    fetchCityVM: FetchCityViewModel = viewModel(),
) {
    val fetchCityState by fetchCityVM.viewState

    var i = 0
    i++
    // Log.d("Logging", "MainScreen $i")
    fetchCityVM.viewState.collectAsState().value.cityData?.let {
        vm.fetchForecast(it.lat, it.lon)
        //Log.d("Logging", "Loading VM")
    }

    val state = vm.viewState.collectAsState()
    val mainState = state.value.forecastData

    mainState?.let {
        // Log.d("Logging", "column $i")
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = CityBackground)
        ) {
            if (state.value.isLoading) {
                CircularProgressIndicator(modifier.height(160.dp))
            }
            mainState?.forecastList?.let { itemForecast ->
                Box(modifier = modifier.weight(3f)) {
                    CurrentWeatherDisplay(
                        city = mainState.cityDetail.cityName,
                        weatherIcon = itemForecast[0].meteorology[0].id,
                        temp = itemForecast[0].temp,
                        weatherDesc = itemForecast[0].meteorology[0].description,
                        currentDateTime = itemForecast[0].dateTime
                    )
                }

                Box(modifier = modifier.weight(1f)) {
                    WeatherForecastDisplay(
                        forecastData = mainState,
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

}