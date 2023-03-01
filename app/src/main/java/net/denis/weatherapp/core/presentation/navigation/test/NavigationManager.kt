package net.denis.weatherapp.core.presentation.navigation.test

import kotlinx.coroutines.flow.MutableStateFlow
import net.denis.weatherapp.core.presentation.navigation.test.CurrentForecastDirections.Default

class NavigationManager {
    var commands = MutableStateFlow(Default)

    fun navigate(
        directions: NavigationCommand
    ) {
        commands.value = directions
    }

}