package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
private const val PARAM_QUERY = "city"

@Composable
fun NavGraph(
    navController: NavHostController,
    vm: ForecastViewModel,
) {
    val state = vm.viewState.collectAsState()
    val weather = state.value.meteorologyItem

    NavHost(
        navController = navController,
        startDestination = Screen.DetailForecastScreen.route
    ) {
        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            if (weather != null) {
                CityCurrentWeatherScreen(navController = navController, weather = weather)
            }
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
            if (cnt != null && weather != null) {
                CityDetailWeatherScreen(currentCnt = cnt, weather = weather)
            }
        }

        composable(
            route = Screen.SearchCityScreen.route,
            arguments = listOf(
                navArgument(PARAM_QUERY) {
                    type = NavType.StringType
                    defaultValue = "Москва"
                }
            )
        ) { navBackStackEntry ->
            val city = navBackStackEntry.arguments?.getString(PARAM_QUERY)
            if (city != null) {
                FindNewCityScreen(city = city)
            }
        }
    }

}