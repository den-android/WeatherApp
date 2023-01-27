package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class ForecastReducer : Reducer<ForecastState, ForecastAction> {

    override fun reduce(currentState: ForecastState, action: ForecastAction): ForecastState {
        return when (action) {

            is ForecastAction.ForecastLoading -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is ForecastAction.CurrentForecastLoaded -> {
                currentState.copy(
                    isLoading = false,
                    meteorologyItem = action.meteorologyItem,
                )
            }

            else -> currentState
        }
    }

}