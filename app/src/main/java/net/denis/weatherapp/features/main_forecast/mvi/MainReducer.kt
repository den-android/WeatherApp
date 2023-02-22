package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class MainReducer : Reducer<MainState, MainAction> {

    override fun reduce(currentState: MainState, action: MainAction): MainState {
        return when (action) {

            is MainAction.FetchingForecast -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is MainAction.ForecastLoaded -> {
                currentState.copy(
                    isLoading = false,
                    forecastData = action.forecastData,
                )
            }

            is MainAction.ShowError -> {
                currentState.copy(
                    isLoading = false,
                    error = action.failureResponse
                )
            }

            is MainAction.ClearErrorState -> {
                currentState.copy(
                    error = null
                )
            }

            else -> currentState

        }
    }
}