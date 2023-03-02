package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailScreen
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.FetchCityScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

@Composable
fun SetupNavGraph(
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
                onRangeTimeClicked = { hourlyItem ->
                    detailVM.getHourlyItem(hourlyItem)
                    navController.navigate(route = Screen.DetailScreen.route)
                },
                onFabClicked = {
                    navController.navigate(Screen.FetchCityScreen.route)
                }
            )
        }

        composable(route = Screen.DetailScreen.route) {
            DetailScreen(
                vm = detailVM,
                onActionErrorClicked = {
                    navController.popBackStack(Screen.DetailScreen.route, inclusive = true)
                }
            )
        }

        composable(route = Screen.FetchCityScreen.route) {
            FetchCityScreen(
                vm = fetchCityVM,
                navigateUp = {
                    mainVM.fetchForecast(lat = it.lat, lon = it.lon)
                    navController.popBackStack(Screen.FetchCityScreen.route, inclusive = true)
                },
                onActionErrorClicked = {
                    navController.popBackStack(Screen.FetchCityScreen.route, inclusive = true)
                    navController.navigate(Screen.FetchCityScreen.route)
                }
            )
        }

    }
}