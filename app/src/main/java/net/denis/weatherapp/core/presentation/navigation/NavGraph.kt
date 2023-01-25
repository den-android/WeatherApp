package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.CityCurrentWeatherScreen
import net.denis.weatherapp.features.forecast.screen.CityDetailWeatherScreen

private const val PARAM_CNT = "cnt"

@Composable
fun NavGraph(
    navController: NavHostController,
    vm: ForecastViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CurrentForecast.route
    ) {
        composable(
            route = Screen.CurrentForecast.route
        ) {
            CityCurrentWeatherScreen(navController = navController, vm = vm)
        }

        composable(
            route = Screen.DetailForecast.route,
            arguments = listOf(
                navArgument(PARAM_CNT) {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )
        ) { navBackStackEntry ->
            val cnt = navBackStackEntry.arguments?.getInt(PARAM_CNT)
            if (cnt != null) {
                CityDetailWeatherScreen(currentCnt = cnt, vm = vm)
            }
        }
    }

}