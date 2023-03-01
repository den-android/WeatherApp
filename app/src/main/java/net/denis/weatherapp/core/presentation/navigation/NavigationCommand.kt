package net.denis.weatherapp.core.presentation.navigation

import androidx.navigation.NamedNavArgument

interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}