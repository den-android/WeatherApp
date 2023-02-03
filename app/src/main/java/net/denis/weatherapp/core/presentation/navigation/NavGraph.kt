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

private const val PARAM_POSITION = "position"
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
                navArgument(PARAM_POSITION) {
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ) { navBackStackEntry ->
            val position = navBackStackEntry.arguments?.getInt(PARAM_POSITION)
            position?.let { position ->
                detailVM.getPosition(position)
                DetailWeatherScreen(
                    vm = detailVM
                    //detailData = forecastState.forecastList[id].detailData
                )
            }
        }

    }

}