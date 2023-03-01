package net.denis.weatherapp.core.presentation.navigation.test

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = CurrentForecastDirections.testCurrentForecast.destination
    ) {

        composable(CurrentForecastDirections.testCurrentForecast.destination) { backStackEntry ->
            val vmCurrent = hiltViewModel<TestCurrentVM>()
            testCurrentScreen(vm = vmCurrent)
        }

    }

}