package net.denis.weatherapp.core.presentation.navigation.test

import androidx.navigation.NamedNavArgument

object ForecastDirections {

    val Default = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val testCurrentForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "test_current_forecast"
    }

    val CurrentForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "current_forecast"
    }

    val DetailForecast = object : NavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "detail_forecast"
    }
}