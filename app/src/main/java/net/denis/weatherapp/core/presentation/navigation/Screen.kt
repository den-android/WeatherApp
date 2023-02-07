package net.denis.weatherapp.core.presentation.navigation

import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class Screen(val route: String) {

    object MainForecastScreen : Screen(route = "MainForecastScreen")

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?position={position}") {
        fun passDetailPosition(position: DetailData): String {
            return "DetailForecastScreen?position=$position"
        }
    }

    object FetchCityScreen:Screen(route = "FetchCityScreen")

}