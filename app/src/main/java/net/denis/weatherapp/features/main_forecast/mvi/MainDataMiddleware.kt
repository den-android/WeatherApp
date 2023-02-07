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
            is MainAction.ForecastLoading -> {
                forecastLoading(store)
            }
            else -> currentState
        }
    }

    private suspend fun forecastLoading(store: Store<MainState, MainAction>) {
        weatherRepository.getForecast(
            lat = 55.7504461,
            lon = 37.6174943,
        ).collect { data ->
            val forecastData = data.toForecastData()

            store.dispatch(MainAction.ForecastLoaded(forecastData = forecastData))
        }
    }
}