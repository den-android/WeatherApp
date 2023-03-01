package net.denis.weatherapp.core.presentation.navigation.test

import androidx.navigation.NamedNavArgument

object CurrentForecastDirections {

    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val root = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "connect"
    }

    val testCurrentForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "test_current_forecast"
    }

    val testDetailForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "test_detail_forecast"
    }

    val testFetchCity = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "test_fetch_city"
    }

}