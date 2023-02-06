package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.weatherapp.core.util.Constants.PARAM_DETAIL_SCREEN
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

@Composable
fun NavGraph(
    navController: NavHostController,
    forecastVM: MainViewModel,
    detailVM: DetailViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CurrentForecastScreen.route
    ) {

        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            MainScreen(navController = navController, vm = forecastVM)
        }

        composable(route = Screen.DetailForecastScreen.route) {
            val detailDataItem =
                navController.previousBackStackEntry?.savedStateHandle?.get<DetailData>(PARAM_DETAIL_SCREEN)
            detailDataItem?.let {
                detailVM.getDetailDataItem(it)
                DetailWeatherScreen(vm = detailVM)
            }
        }

    }
}