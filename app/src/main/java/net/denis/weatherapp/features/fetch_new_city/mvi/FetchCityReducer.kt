package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.presentation.redux.Reducer
import net.denis.weatherapp.features.main_forecast.mvi.MainAction

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

            is FetchCityAction.ShowError -> {
                currentState.copy(
                    isLoading = false,
                    error = action.failureResponse
                )
            }

            is FetchCityAction.ClearErrorState -> {
                currentState.copy(
                    error = null
                )
            }

            else -> currentState

        }
    }
}