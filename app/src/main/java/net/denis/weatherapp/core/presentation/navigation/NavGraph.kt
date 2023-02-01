package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.features.forecast.mvi.CurrentViewModel
import net.denis.weatherapp.features.forecast.screen.CurrentWeatherScreen
import net.denis.weatherapp.features.forecast.screen.FindNewCityScreen
import net.denis.weatherapp.features.forecast_at_three_hour.mvi.DetailViewModel
import net.denis.weatherapp.features.forecast_at_three_hour.screen.DetailWeatherScreen

private const val PARAM_CNT = "cnt"
private const val PARAM_QUERY = "city"

@Composable
fun NavGraph(
    navController: NavHostController,
    detailVM: DetailViewModel,
    currentVM: CurrentViewModel,
) {
    val currentState = currentVM.viewState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Screen.CurrentForecastScreen.route
    ) {
        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            CurrentWeatherScreen(navController = navController, weatherState = currentState)
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
            currentId?.let {
                detailVM.getCurrentId(it)
                DetailWeatherScreen(vm = detailVM)
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
            city?.let {
                FindNewCityScreen(city = city)
            }
        }
    }

}