package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store

class ForecastDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<ForecastState, ForecastAction> {

    override suspend fun process(
        action: ForecastAction,
        currentState: ForecastState,
        store: Store<ForecastState, ForecastAction>
    ) {
        when (action) {
            is ForecastAction.ForecastLoading -> {
                forecastLoading(store)
            }
            else -> currentState
        }
    }

    private suspend fun forecastLoading(store: Store<ForecastState, ForecastAction>) {
        weatherRepository.getForecast(
            lat = 55.7504461,
            lon = 37.6174943,
            apiKey = "b05865d24d90b1dbccfb3ced2627b4e9"
        ).collect { data ->
            val forecastData = data.toForecastData()

            store.dispatch(ForecastAction.CurrentForecastLoaded(forecastData = forecastData))
        }
    }
}