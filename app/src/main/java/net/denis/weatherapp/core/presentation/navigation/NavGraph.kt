package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.core.util.Constants.PARAM_LAT
import net.denis.weatherapp.core.util.Constants.PARAM_LON
import net.denis.weatherapp.core.util.Constants.PARAM_POSITION
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
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
    val mainState = mainVM.viewState.collectAsState().value.forecastData
    val cityState = fetchCityVM.viewState.collectAsState().value.cityData

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {

        composable(
            route = Screen.MainScreen.route,
            arguments = listOf(
                navArgument(PARAM_LAT) { type = NavType.StringType },
                navArgument(PARAM_LON) { type = NavType.StringType }
            )
        ) {
            cityState?.let {
                mainVM.fetchForecast(lat = it.lat, lon = it.lon).also {
                    MainScreen(navController = navController, vm = mainVM)
                }
            } ?: mainVM.fetchForecast(lat = 47.2213858, lon = 39.7114196).also {
                MainScreen(navController = navController, vm = mainVM)
            }
        }

        composable(
            route = Screen.DetailScreen.route,
            arguments = listOf(navArgument(PARAM_POSITION) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            navBackStackEntry.arguments?.getInt(PARAM_POSITION)?.let { position ->
                mainState?.let { forecastData ->
                    detailVM.getDetailData(forecastData.forecastList[position].detailData)
                }
                DetailWeatherScreen(vm = detailVM)
            }
        }

        composable(route = Screen.FetchCityScreen.route) {
            FetchCityScreen(navController = navController, vm = fetchCityVM)
        }

    }
}