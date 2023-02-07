package net.denis.weatherapp.features.fetch_new_city.mvi

import net.denis.weatherapp.core.data.interfaces.IGeocodingRepository
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class FetchCityStore @Inject constructor(
    geocodingRepository: IGeocodingRepository,
) : BaseStore<FetchCityState, FetchCityAction>(
    initialState = FetchCityState(),
    reducer = FetchCityReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        FetchCityDataMiddleware(geocodingRepository),
    )
)