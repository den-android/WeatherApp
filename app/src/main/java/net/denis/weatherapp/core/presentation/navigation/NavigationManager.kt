package net.denis.weatherapp.core.presentation.navigation

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class NavigationManager(
    private val externalScope: CoroutineScope
) {
    var commands = MutableSharedFlow<INavigationCommand>()

    fun navigate(
        directions: INavigationCommand
    ) {
        externalScope.launch {
            commands.emit(directions)
        }
    }

}