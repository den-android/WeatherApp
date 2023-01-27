package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import android.util.Log
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.presentation.redux.Store

class LoggingMiddleware<S : State, A : Action> : Middleware<S, A> {
    override suspend fun process(action: A, currentState: S, store: Store<S, A>) {
        Log.v(
            "LoggingMiddleware",
            "Processing action: $action Current state: $currentState"
        )
    }
}