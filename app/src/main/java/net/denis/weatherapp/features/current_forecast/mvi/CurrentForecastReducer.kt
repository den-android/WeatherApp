package net.denis.weatherapp.features.current_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class CurrentForecastReducer : Reducer<CurrentForecastState, CurrentForecastAction> {

    override fun reduce(currentState: CurrentForecastState, action: CurrentForecastAction): CurrentForecastState {
        return when (action) {

            is CurrentForecastAction.FetchingForecast -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is CurrentForecastAction.ForecastLoaded -> {
                currentState.copy(
                    isLoading = false,
                    forecastData = action.forecastData,
                )
            }

            is CurrentForecastAction.SendErrorToUI -> {
                currentState.copy(
                    isLoading = false,
                    failureResponse = action.failureResponse
                )
            }

            is CurrentForecastAction.ClearErrorState -> {
                currentState.copy(
                    isLoading = false,
                    failureResponse = null,
                )
            }
            else -> currentState

        }
    }
}