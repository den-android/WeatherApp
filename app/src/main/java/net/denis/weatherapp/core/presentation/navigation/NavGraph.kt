package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import net.denis.weatherapp.core.util.Constants.PARAM_TO_DETAIL_SCREEN
import net.denis.weatherapp.core.util.Constants.PARAM_TO_MAIN_SCREEN
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailWeatherScreen
import net.denis.weatherapp.features.fetch_new_city.model.CityData
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

    NavHost(
        navController = navController,
        startDestination = Screen.MainForecastScreen.route
    ) {

        composable(
            route = Screen.MainForecastScreen.route,
        ) { navBackStackEntry ->

            val cityDataItem =
                navController.previousBackStackEntry?.savedStateHandle?.get<CityData>(
                    PARAM_TO_MAIN_SCREEN
                )

            cityDataItem?.let {
                mainVM.fetchForecastByCityCoords(lat = it.lat, lon = it.lon)
                MainScreen(navController = navController, vm = mainVM)
            } ?: mainVM.fetchForecastByCityCoords(lat = 47.2213858, lon = 39.7114196).also {
                MainScreen(navController = navController, vm = mainVM)
            }

        }

        composable(
            route = Screen.DetailForecastScreen.route,
            arguments = listOf(navArgument(PARAM_TO_DETAIL_SCREEN) {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->

            navBackStackEntry.arguments?.getInt(PARAM_TO_DETAIL_SCREEN)?.let { position ->
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