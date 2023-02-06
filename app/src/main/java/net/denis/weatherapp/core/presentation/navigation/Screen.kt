package net.denis.weatherapp.core.presentation.navigation

import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class Screen(val route: String) {

    object CurrentForecastScreen : Screen(route = "CurrentForecastScreen")

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?position={position}") {
        fun passDetailPosition(position: DetailData): String {
            return "DetailForecastScreen?position=$position"
        }
    }

}