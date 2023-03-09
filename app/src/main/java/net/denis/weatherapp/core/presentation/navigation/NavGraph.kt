package net.denis.weatherapp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailScreen
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.FetchCityScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

@Composable
fun NavGraph(
    navigationManager: NavigationManager,
    navController: NavHostController
) {
    LaunchedEffect(navigationManager.commands) {
        navigationManager.commands.collect { command ->
            if (command.destination.isNotEmpty()) {
                navController.navigate(command.destination)
            }
        }
    }

    NavHost(
        navController = navController,
        startDestination = ForecastDirections.CurrentForecast.destination
    ) {

        composable(ForecastDirections.CurrentForecast.destination) { backStackEntry ->
            MainScreen(vm = hiltViewModel<MainViewModel>())
        }

        composable(ForecastDirections.DetailForecast.destination) { backStackEntry ->
            DetailScreen(vm = hiltViewModel<DetailViewModel>())
        }

        composable(ForecastDirections.FetchNewCity.destination) { backStackEntry ->
            FetchCityScreen(vm = hiltViewModel<FetchCityViewModel>())
        }

    }

}
