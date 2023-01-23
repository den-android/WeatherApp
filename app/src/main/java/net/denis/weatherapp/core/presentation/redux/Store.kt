package net.denis.weatherapp.core.presentation.redux

import kotlinx.coroutines.flow.StateFlow

interface Store<S : State, A : Action> {

    val state: StateFlow<S>

    suspend fun dispatch(action: A)
}