package net.denis.weatherapp.core.presentation.navigation.test

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = NavigationDirections.testCurrentForecast.destination
    ) {

        composable(NavigationDirections.testCurrentForecast.destination) { backStackEntry ->
            val vmCurrent = hiltViewModel<TestCurrentVM>()
            testCurrentScreen(vm = vmCurrent)
        }

        composable(NavigationDirections.testCurrentForecast.destination) { backStackEntry ->

            val parentEntry = remember(backStackEntry) {
                navController.getBackStackEntry(route = NavigationDirections.testCurrentForecast.destination)
            }
            val vmDetail = hiltViewModel<TestDetailVM>(parentEntry)
            testDetailForecast(vm = vmDetail)
        }

        composable(NavigationDirections.testCurrentForecast.destination) { backStackEntry ->
            val vmFetch = hiltViewModel<TestFetchVM>()
            testFetchCityScreen(vm = vmFetch)
        }

    }

}