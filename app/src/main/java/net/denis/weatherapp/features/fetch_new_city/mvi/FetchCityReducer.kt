package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer

class FetchCityReducer: Reducer<FetchCityState, FetchCityAction> {

    override fun reduce(currentState: FetchCityState, action: FetchCityAction): FetchCityState {
        return when (action) {

            is FetchCityAction.FetchingCity -> {
                currentState.copy(
                    isLoading = true,
                )
            }

            is FetchCityAction.FetchedCity -> {
                currentState.copy(
                    isLoading = false,
                    cityName = action.cityData
                )
            }

            else -> currentState

        }
    }
}