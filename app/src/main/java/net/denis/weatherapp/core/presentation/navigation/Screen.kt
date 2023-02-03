package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object CurrentForecastScreen : Screen(route = "CurrentForecastScreen")

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?position={position}") {
        fun passDetailPosition(position: Int = 0): String {
            return "DetailForecastScreen?position=$position"
        }
    }

}