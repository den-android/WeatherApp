package net.denis.weatherapp.core.presentation.navigation.directions

import androidx.navigation.NamedNavArgument
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import net.denis.weatherapp.core.util.Constants.PARAM_LAT
import net.denis.weatherapp.core.util.Constants.PARAM_LON

object CurrentForecastDirections {

    val Default = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = ""
    }

    val CurrentForecast = object : INavigationCommand {
        override val arguments = emptyList<NamedNavArgument>()
        override val destination = "current_forecast?=$PARAM_LAT={$PARAM_LAT}?=$PARAM_LON={$PARAM_LON}"
    }
    fun sendParamToDetailForecast() {

    }

}