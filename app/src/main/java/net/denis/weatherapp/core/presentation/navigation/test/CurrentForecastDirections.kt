package net.denis.weatherapp.core.presentation.navigation.test

import androidx.navigation.NamedNavArgument

object CurrentForecastDirections {

    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val testCurrentForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "test_current_forecast"
    }

}