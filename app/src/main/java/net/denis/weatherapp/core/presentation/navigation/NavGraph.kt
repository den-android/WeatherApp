package net.denis.weatherapp.core.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.weatherapp.core.util.Constants
import net.denis.weatherapp.core.util.Constants.PARAM_TO_DETAIL_SCREEN
import net.denis.weatherapp.core.util.Constants.PARAM_TO_MAIN_SCREEN
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.FetchCityScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    mainVM: MainViewModel,
    detailVM: DetailViewModel,
    fetchCityVM: FetchCityViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.MainForecastScreen.route
    ) {

        composable(
            route = Screen.MainForecastScreen.route
        ) {
            val cityDataItem = navController.previousBackStackEntry?.savedStateHandle?.get<CityData>(PARAM_TO_MAIN_SCREEN)
            cityDataItem?.let {
                mainVM.fetchForecastByCityName(lat = it.lat, lon = it.lon)
                MainScreen(navController = navController, vm = mainVM)
            } ?: mainVM.fetchForecastByCityName(lat = 55.7504461, lon = 37.6174943).also {
                MainScreen(navController = navController, vm = mainVM)
            }
        }

        composable(route = Screen.DetailForecastScreen.route) {
            val detailDataItem =
                navController.previousBackStackEntry?.savedStateHandle?.get<DetailData>(
                    PARAM_TO_DETAIL_SCREEN
                )
            detailDataItem?.let {
                detailVM.getDetailDataItem(it)
                DetailWeatherScreen(vm = detailVM)
            }
        }

        composable(route = Screen.FetchCityScreen.route) {
            FetchCityScreen(navController = navController, vm = fetchCityVM)
        }

    }
}