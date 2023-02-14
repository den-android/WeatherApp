package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.toForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.catchLog

class MainDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<MainState, MainAction> {

    override suspend fun process(
        action: MainAction,
        currentState: MainState,
        store: Store<MainState, MainAction>
    ) {
        when (action) {
            is MainAction.FetchForecast -> {
                fetchForecast(lat = action.lat, lon = action.lon, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun fetchForecast(lat: Double, lon: Double, store: Store<MainState, MainAction>) {
        store.dispatch(MainAction.FetchingForecast)
        weatherRepository.fetchForecast(lat = lat, lon = lon).catchLog().collect { data ->
            store.dispatch(MainAction.ForecastLoaded(forecastData = data.toForecastData()))
        }
    }
}