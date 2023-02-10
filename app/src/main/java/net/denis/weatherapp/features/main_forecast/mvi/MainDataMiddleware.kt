package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.toForecastData
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store

class MainDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<MainState, MainAction> {

    override suspend fun process(
        action: MainAction,
        currentState: MainState,
        store: Store<MainState, MainAction>
    ) {
        when (action) {
            is MainAction.FetchCurrentForecast -> {
                fetchCurrentForecast(store = store)
            }

            is MainAction.FetchForecastByCoords -> {
                fetchForecastByCoords(lat = action.lat, lon = action.lon, store)
            }
            else -> currentState
        }
    }

    private suspend fun fetchCurrentForecast(store: Store<MainState, MainAction>) {
        weatherRepository.fetchForecast(lat = 47.2213858, lon = 39.7114196).collect { data ->
            store.dispatch(MainAction.ForecastLoaded(forecastData = data.toForecastData()))
        }
    }

    private suspend fun fetchForecastByCoords(lat: Double, lon: Double, store: Store<MainState, MainAction>) {
        weatherRepository.fetchForecast(lat = lat, lon = lon,).collect { data ->
            store.dispatch(MainAction.ForecastLoaded(forecastData = data.toForecastData()))
        }
    }
}