package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class DetailReducer : Reducer<DetailState, DetailAction> {

    override fun reduce(currentState: DetailState, action: DetailAction): DetailState {
        return when (action) {

            is DetailAction.GetCurrentId -> {
                currentState.copy(
                    isLoading = true
                )
            }

            is DetailAction.DetailForecastLoaded -> {
                currentState.copy(
                    isLoading = false,
                    detail = action.detail,
                )
            }

            else -> currentState
        }
    }

}