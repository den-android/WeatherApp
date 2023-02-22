package net.denis.weatherapp.core.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.withContext
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailScreen
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.FetchCityScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen
import kotlin.system.exitProcess

@Composable
fun NavGraph(
    mainVM: MainViewModel = viewModel(),
    detailVM: DetailViewModel = viewModel(),
    fetchCityVM: FetchCityViewModel = viewModel(),
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            MainScreen(
                vm = mainVM,
                onRangeTimeClick = { position, forecastData ->
                    detailVM.getDetailData(forecastData.forecastList[position].detailData)
                    navController.navigate(route = Screen.DetailScreen.route)
                },
                onFabClick = {
                    navController.navigate(Screen.FetchCityScreen.route)
                },
                onDismissClicked = {
                    Log.d("Logging", "NAV 1")
                    mainVM.clearErrorState()
                    mainVM::class.java
                    Log.d("Logging", "NAV 2")
                }
            )
        }

        composable(route = Screen.DetailScreen.route) {
            DetailScreen(vm = detailVM)
        }

        composable(route = Screen.FetchCityScreen.route) {
            FetchCityScreen(
                vm = fetchCityVM,
                navigateUp = {
                    mainVM.fetchForecast(lat = it.lat, lon = it.lon)
                    navController.popBackStack(Screen.FetchCityScreen.route, inclusive = true)
                }
            )
        }

    }
}