package net.denis.weatherapp.core.presentation.navigation

sealed class Screen(val route: String) {

    object CurrentForecast : Screen(route = "CurrentForecast")

    object DetailForecast : Screen(route = "DetailForecast?cnt={cnt}") {
        fun passDetailCnt(cnt: Int = 0): String {
            return "DetailForecast?cnt=$cnt"
        }
    }

}