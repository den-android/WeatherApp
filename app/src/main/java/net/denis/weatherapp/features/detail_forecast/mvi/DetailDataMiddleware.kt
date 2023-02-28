package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store

class DetailDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<DetailState, DetailAction> {

    override suspend fun process(
        action: DetailAction,
        currentState: DetailState,
        store: Store<DetailState, DetailAction>
    ) {
        when (action) {
            is DetailAction.GetForecastItem -> {
                action.forecastItem
            }

            else -> currentState
        }
    }

}