package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object MainScreen : Screen(route = "main_screen/lat={lat}/lon={lon}") {
        fun passCoords(lat: Double, lon: Double): String {
            return "main_screen/lat=$lat/lon=$lon"
        }
    }

    object DetailScreen : Screen(route = "detail_screen/position={position}") {
        fun passDetailPosition(position: Int): String {
            return "detail_screen/position=$position"
        }
    }

    object FetchCityScreen:Screen(route = "fetch_city_screen")

}