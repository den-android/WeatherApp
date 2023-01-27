package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.features.forecast.mvi.CurrentViewModel
import net.denis.weatherapp.features.forecast.screen.FindNewCityScreen
import net.denis.weatherapp.features.forecast_at_three_hour.mvi.DetailViewModel
import net.denis.weatherapp.features.forecast_at_three_hour.screen.DetailWeatherScreen

private const val PARAM_CNT = "cnt"
private const val PARAM_QUERY = "city"

@Composable
fun NavGraph(
    navController: NavHostController,
    currentVM: CurrentViewModel,
    detailVM: DetailViewModel,
) {
    val currentState = currentVM.viewState.collectAsState()
    val weatherCurrent = currentState.value.meteorologyItem

    val detailState = detailVM.viewState.collectAsState()
    val weatherDetail = detailState.value.detail

    NavHost(
        navController = navController,
        startDestination = Screen.DetailForecastScreen.route
    ) {
        composable(
            route = Screen.CurrentForecastScreen.route
        ) {
            if (weatherCurrent != null) {
                //CityCurrentWeatherScreen(navController = navController, weather = weatherCurrent)
            }
        }
        composable(
            route = Screen.DetailForecastScreen.route
        ) {
            if (weatherDetail != null) {
                DetailWeatherScreen(detail = weatherDetail, currentCnt = 0)
            }
        }

//        composable(
//            route = Screen.DetailForecastScreen.route,
//            arguments = listOf(
//                navArgument(PARAM_CNT) {
//                    type = NavType.IntType
//                    defaultValue = 0
//                }
//            )
//        ) { navBackStackEntry ->
//            val cnt = navBackStackEntry.arguments?.getInt(PARAM_CNT)
//            if (cnt != null && weatherDetail != null) {
//                DetailWeatherScreen(currentCnt = cnt, detailData = weatherDetail)
//            }
//        }
// forecast?cnt=7&exclude=alerts&lang=ru&lat=55.75&lon=37.62&units=metric
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