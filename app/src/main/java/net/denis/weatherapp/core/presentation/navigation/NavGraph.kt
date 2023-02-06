package net.denis.weatherapp.core.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

private const val PARAM_POSITION = "position"
private const val PARAM_QUERY = "city"

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
                navController.previousBackStackEntry?.savedStateHandle?.get<DetailData>("detailData")
            detailDataItem?.let {
                detailVM.getDetail(it)
                Log.d("Logging","NAV GRAPH ${it}")
                DetailWeatherScreen(vm = detailVM)
            }

        }

    }

}