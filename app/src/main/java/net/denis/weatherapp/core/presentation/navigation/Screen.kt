package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object MainScreen : Screen(route = "main_screen")

    object DetailScreen : Screen(route = "detail_screen")

    object FetchCityScreen:Screen(route = "fetch_city_screen")

}