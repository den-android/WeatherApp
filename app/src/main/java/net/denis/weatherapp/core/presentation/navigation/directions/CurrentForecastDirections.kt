package net.denis.weatherapp.core.presentation.navigation.directions

import androidx.navigation.NamedNavArgument
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand

object CurrentForecastDirections {

    val Default = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val CurrentForecast = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "current_forecast"
    }

}