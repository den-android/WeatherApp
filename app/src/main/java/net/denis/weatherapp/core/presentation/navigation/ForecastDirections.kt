package net.denis.weatherapp.core.presentation.navigation

import androidx.navigation.NamedNavArgument

object ForecastDirections {

    val Default = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val CurrentForecast = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "current_forecast"
    }

    val DetailForecast = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "detail_forecast"
    }

    val FetchNewCity = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "fetch_new_city"
    }
}