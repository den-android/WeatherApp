package net.denis.weatherapp.features.main_forecast.mvi

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
            is MainAction.MainLoading -> {
                forecastLoading(store)
            }
            else -> currentState
        }
    }

    private suspend fun forecastLoading(store: Store<MainState, MainAction>) {
        weatherRepository.getForecast(
            lat = 55.7504461,
            lon = 37.6174943,
            apiKey = "b05865d24d90b1dbccfb3ced2627b4e9"
        ).collect { data ->
            val forecastData = data.toForecastData()

            store.dispatch(MainAction.CurrentMainLoaded(forecastData = forecastData))
        }
    }
}