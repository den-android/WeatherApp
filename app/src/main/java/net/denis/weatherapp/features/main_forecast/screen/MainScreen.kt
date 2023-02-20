package net.denis.weatherapp.features.main_forecast.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    vm: MainViewModel,
    fetchCityVM: FetchCityViewModel,
) {
    if (vm.viewState.collectAsState().value.isLoading) {
        CircularProgressIndicator()
    }
//    val fetchCityState by fetchCityVM.viewState.collectAsState()
//    val mainState by vm.viewState.collectAsState()
//
    var i = 0
    i++
//     Log.d("Logging", "MainScreen $i")
//    fetchCityVM.viewState.collectAsState().value.cityData?.let {
//        vm.fetchForecast(it.lat, it.lon)
        Log.d("Logging", "Loading VM")
//    }
//
//    mainState?.let { state ->
//         Log.d("Logging", "column $i")
//        Column(
//            modifier = modifier
//                .fillMaxSize()
//                .background(color = CityBackground)
//        ) {
//            if (state.isLoading) {
//                CircularProgressIndicator(modifier.height(160.dp))
//            }
//            state.forecastData?.forecastList?.let { itemForecast ->
//                Box(modifier = modifier.weight(3f)) {
//                    CurrentWeatherDisplay(
//                        city = state.forecastData.cityDetail.cityName,
//                        weatherIcon = itemForecast[0].meteorology[0].id,
//                        temp = itemForecast[0].temp,
//                        weatherDesc = itemForecast[0].meteorology[0].description,
//                        currentDateTime = itemForecast[0].dateTime
//                    )
//                }
//
//                Box(modifier = modifier.weight(1f)) {
//                    WeatherForecastDisplay(
//                        forecastData = state.forecastData,
//                        onClick = {
//                            navController.navigate(
//                                route = Screen.DetailScreen.passDetailPosition(it)
//                            )
//                        }
//                    )
//                }
//            }
            BottomNavigateMenu(modifier.padding(top=330.dp),
                onFabClicked = {
                navController.navigate(
                    route = Screen.FetchCityScreen.route
                )
            })
//        }
//    }

}