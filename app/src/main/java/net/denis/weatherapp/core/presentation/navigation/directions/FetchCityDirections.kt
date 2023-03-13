package net.denis.weatherapp.core.presentation.navigation.directions

import androidx.navigation.NamedNavArgument
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand

object FetchCityDirections {

    val FetchNewCity = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "fetch_new_city"
    }

}