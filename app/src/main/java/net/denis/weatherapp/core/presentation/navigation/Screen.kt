package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object MainScreen : Screen(route = "main_screen")

    object DetailScreen : Screen(route = "detail_screen/position={position}") {
        fun passDetailPosition(position: Int): String {
            return "detail_screen/position=$position"
        }
    }

    object FetchCityScreen:Screen(route = "fetch_city_screen")

}