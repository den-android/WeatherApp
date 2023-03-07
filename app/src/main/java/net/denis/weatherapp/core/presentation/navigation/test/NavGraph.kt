package net.denis.weatherapp.core.presentation.navigation.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen
import javax.inject.Inject

const val DetailKEY = "hourlyItem"
@Composable
fun NavGraph() {

    val navController = rememberNavController()
//    navigationManager.commands.collectAsState().value.also { command ->
//        if (command.destination.isNotEmpty()) navController.navigate(command.destination)
//    }
    NavHost(
        navController = navController,
        startDestination = ForecastDirections.testCurrentForecast.destination
    ) {

        composable(ForecastDirections.testCurrentForecast.destination) { backStackEntry ->
            testCurrentScreen(vm = hiltViewModel<TestCurrentVM>())
        }

        composable(ForecastDirections.CurrentForecast.destination) { backStackEntry ->
            MainScreen(
                vm = hiltViewModel<MainViewModel>(),
                onRangeTimeClicked = { },
                onFabClicked = {})
        }

        composable(ForecastDirections.DetailForecast.destination) { backStackEntry ->
            DetailScreen(
                vm = hiltViewModel<DetailViewModel>(),
                onActionErrorClicked = {}
            )
        }

    }

}
