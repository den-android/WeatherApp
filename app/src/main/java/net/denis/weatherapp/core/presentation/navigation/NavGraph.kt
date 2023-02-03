package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
import net.denis.weatherapp.features.main_forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.main_forecast.screen.ForecastWeatherScreen

private const val PARAM_CNT = "id"
private const val PARAM_QUERY = "city"

@Composable
fun NavGraph(
    navController: NavHostController,
    forecastVM: ForecastViewModel,
    detailVM: DetailViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.CurrentForecastScreen.route
    ) {
        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            ForecastWeatherScreen(navController = navController, vm = forecastVM)
        }

        composable(
            route = Screen.DetailForecastScreen.route,
            arguments = listOf(
                navArgument(PARAM_CNT) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { navBackStackEntry ->
            val currentId = navBackStackEntry.arguments?.getInt(PARAM_CNT)
            currentId?.let { id ->
                DetailWeatherScreen(
                    vm = detailVM,
                    //detailData = forecastState.forecastList[id].detailData
                )
            }
        }

    }

}