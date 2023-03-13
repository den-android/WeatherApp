package net.denis.weatherapp.core.presentation.navigation.directions

import androidx.navigation.NamedNavArgument
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand

object DetailForecastDirections {

    val DetailForecast = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "detail_forecast"
    }

}