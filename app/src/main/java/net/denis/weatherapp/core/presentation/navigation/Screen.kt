package net.denis.weatherapp.core.presentation.navigation

import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.model.CityData

sealed class Screen(val route: String) {

    object MainForecastScreen : Screen(route = "MainForecastScreen?cityData={cityData}") {
        fun passCoords(cityData: CityData): String {
            return "MainForecastScreen?cityData=$cityData"
        }
    }

    object DetailForecastScreen : Screen(route = "DetailForecastScreen?position={position}") {
        fun passDetailPosition(position: DetailData): String {
            return "DetailForecastScreen?position=$position"
        }
    }

    object FetchCityScreen:Screen(route = "FetchCityScreen")

}