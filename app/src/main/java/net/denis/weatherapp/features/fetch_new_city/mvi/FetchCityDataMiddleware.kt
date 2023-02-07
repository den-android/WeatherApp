package net.denis.weatherapp.features.fetch_new_city.mvi

import android.util.Log
import kotlinx.coroutines.flow.collect
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
            is FetchCityAction.FetchingCity -> {

            }

            else -> currentState
        }
    }

    private suspend fun fetchNewCity(cityName: String, store: Store<FetchCityState, FetchCityAction>) {
        geocodingRepository.fetchNewCity(cityName)
            .collect() { cityList ->
                Log.d("Logging", "${cityList.forEach {it.name}}")
            }
    }
}