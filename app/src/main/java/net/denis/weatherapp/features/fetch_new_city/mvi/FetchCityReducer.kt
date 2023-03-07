package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class FetchCityReducer : Reducer<FetchCityState, FetchCityAction> {

    override fun reduce(currentState: FetchCityState, action: FetchCityAction): FetchCityState {
        return when (action) {

            is FetchCityAction.FetchCity -> {
                currentState.copy(
                    isLoading = true
                )
            }

            is FetchCityAction.CityLoaded -> {
                currentState.copy(
                    isLoading = false,
                    cityData = action.cityData
                )
            }

            is FetchCityAction.SendErrorToUI -> {
                currentState.copy(
                    isLoading = false,
                    failureResponse = action.failureResponse
                )
            }

            is FetchCityAction.ClearErrorState -> {
                currentState.copy(
                    isLoading = false,
                    failureResponse = null,
                )
            }

            else -> currentState

        }
    }
}