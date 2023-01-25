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
import net.denis.weatherapp.features.forecast.screen.FindNewCityScreen

private const val PARAM_CNT = "cnt"
private const val PARAM_QUERRY = "city"

@Composable
fun NavGraph(
    navController: NavHostController,
    vm: ForecastViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CurrentForecastScreen.route
    ) {
        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            CityCurrentWeatherScreen(navController = navController, vm = vm)
        }

        composable(
            route = Screen.DetailForecastScreen.route,
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

        composable(
            route = Screen.SearchCityScreen.route,
            arguments = listOf(
                navArgument(PARAM_QUERRY) {
                    type = NavType.StringType
                    defaultValue = "Москва"
                }
            )
        ) { navBackStackEntry ->
            val city = navBackStackEntry.arguments?.getString(PARAM_QUERRY)
            if (city != null) {
                FindNewCityScreen(city = city, vm = vm)
            }
        }
    }

}