package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer
import net.denis.weatherapp.core.util.FailureResponse

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
                    failureResponse = action.failureResponse
                )
            }

            is MainAction.FixError -> {
                currentState.copy(
                    failureResponse = null
                )
            }

            else -> currentState

        }
    }
}