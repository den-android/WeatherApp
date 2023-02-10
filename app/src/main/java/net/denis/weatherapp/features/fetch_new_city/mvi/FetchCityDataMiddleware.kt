package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.toEnCity
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.toRuCity
import net.denis.weatherapp.core.data.interfaces.IGeocodingRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store

class FetchCityDataMiddleware(
    private val geocodingRepository: IGeocodingRepository,
) : Middleware<FetchCityState, FetchCityAction> {
    override suspend fun process(
        action: FetchCityAction,
        currentState: FetchCityState,
        store: Store<FetchCityState, FetchCityAction>
    ) {
        when (action) {
            is FetchCityAction.FetchCity -> {
                fetchNewCity(cityName = action.name, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun fetchNewCity(cityName: String, store: Store<FetchCityState, FetchCityAction>) {
        geocodingRepository.fetchNewCity(cityName)
            .collect() { cityList ->
                cityList.forEach { cityItem ->
                    try {
                        store.dispatch(FetchCityAction.CityLoaded(cityData = cityItem.toRuCity()))
                    } catch (e: Exception) {
                        store.dispatch(FetchCityAction.CityLoaded(cityData = cityItem.toEnCity()))
                    }
                }
            }
    }
}