package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class DetailReducer : Reducer<DetailState, DetailAction> {

    override fun reduce(currentState: DetailState, action: DetailAction): DetailState {
        return when (action) {
            is DetailAction.LoadingDetailData -> {
                currentState.copy(
                    isLoading = true
                )
            }

            is DetailAction.LoadedDetailData -> {
                currentState.copy(
                    isLoading = false,
                    detailData = action.detailData,
                )
            }

            else -> currentState
        }
    }

}