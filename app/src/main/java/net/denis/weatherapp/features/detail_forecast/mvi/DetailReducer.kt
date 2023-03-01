package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class DetailReducer : Reducer<DetailState, DetailAction> {

    override fun reduce(currentState: DetailState, action: DetailAction): DetailState {
        return when (action) {

            is DetailAction.GetHourlyItem -> {
                currentState.copy(
                    isLoading = false,
                    hourlyItem = action.hourlyItem,
                )
            }

            is DetailAction.ShowError -> {
                currentState.copy(
                    isLoading = false,
                    error = action.failureResponse
                )
            }

            is DetailAction.ClearErrorState -> {
                currentState.copy(
                    error = null
                )
            }

            else -> currentState
        }
    }

}