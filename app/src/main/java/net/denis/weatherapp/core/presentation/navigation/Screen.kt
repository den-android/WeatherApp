package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object CurrentForecastScreen : Screen(route = "CurrentForecastScreen")

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?cnt={cnt}") {
        fun passDetailCnt(cnt: Int = 0): String {
            return "DetailForecastScreen?cnt=$cnt"
        }
    }

    object SearchCityScreen : Screen(route = "SearchCityScreen?city={city}") {
        fun passQuerry(city: String = "Москва"): String {
            return "SearchCityScreen?city=$city"
        }
    }

}