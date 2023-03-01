package net.denis.weatherapp.core.presentation.navigation.test

import androidx.navigation.NamedNavArgument

interface NavigationCommand {

    val arguments: List<NamedNavArgument>

    val destination: String
}