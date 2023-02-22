package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class DetailReducer : Reducer<DetailState, DetailAction> {

    override fun reduce(currentState: DetailState, action: DetailAction): DetailState {
        return when (action) {

            is DetailAction.GetDetailData -> {
                currentState.copy(
                    isLoading = false,
                    detailData = action.detailData,
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