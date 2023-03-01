package net.denis.weatherapp.core.presentation.navigation

import androidx.navigation.NamedNavArgument

object NavigationDirections {

    val currentForecast = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList<NamedNavArgument>()
        override val destination = "test_current_forecast"
    }

    val detailForecast = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList<NamedNavArgument>()
        override val destination = "test_detail_forecast"
    }

    val fetchCity = object : NavigationCommand {
        override val arguments: List<NamedNavArgument> = emptyList<NamedNavArgument>()
        override val destination = "test_fetch_city"
    }

}