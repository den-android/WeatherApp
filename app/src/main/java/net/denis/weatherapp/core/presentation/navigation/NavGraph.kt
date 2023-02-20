package net.denis.weatherapp.core.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import net.denis.weatherapp.core.util.Constants.PARAM_POSITION
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.DetailScreen
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.FetchCityScreen
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.MainScreen

@Composable
fun NavGraph(
 //   mainVM: MainViewModel,
//    detailVM: DetailViewModel,
   // fetchCityVM: FetchCityViewModel,
) {
    val navController = rememberNavController()

   // val mainState = mainVM.viewState.collectAsState().value.forecastData
//    val fetchCityState = fetchCityVM.viewState.collectAsState().value.cityData

    var i = 0
    NavHost(
        navController = navController,
        startDestination = Screen.MainScreen.route
    ) {
        composable(route = Screen.MainScreen.route) {
            i++
            Log.d("Logging", "Nav graph$i")
            MainScreen(navController = navController)
        }

//        composable(
//            route = Screen.DetailScreen.route,
//            arguments = listOf(navArgument(PARAM_POSITION) {
//                type = NavType.IntType
//            })
//        ) { navBackStackEntry ->
//            navBackStackEntry.arguments?.getInt(PARAM_POSITION)?.let { position ->
//                mainState?.forecastList?.let { listForecast ->
//                    DetailScreen(vm = detailVM, detailData = listForecast[position].detailData)
//                }
//            }
//        }

        composable(route = Screen.FetchCityScreen.route) {
            FetchCityScreen(navController = navController, navigateUp = {
                navController.popBackStack(Screen.FetchCityScreen.route, inclusive = true)
            })
        }

    }
}