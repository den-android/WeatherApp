package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object CurrentForecastScreen : Screen(route = "CurrentForecastScreen")

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?id={id}") {
        fun passDetailId(id: Int = 0): String {
            return "DetailForecastScreen?id=$id"
        }
    }

    object SearchCityScreen : Screen(route = "SearchCityScreen?city={city}") {
        fun passQuery(city: String = "Москва"): String {
            return "SearchCityScreen?city=$city"
        }
    }

}