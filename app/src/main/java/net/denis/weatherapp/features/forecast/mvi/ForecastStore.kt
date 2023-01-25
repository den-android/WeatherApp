package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.data.repository.WeatherRepository
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class ForecastStore @Inject constructor(
    weatherRepository: IWeatherRepository,
) : BaseStore<ForecastState, ForecastAction>(
    initialState = ForecastState(),
    reducer = ForecastReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        ForecastDataMiddleware(weatherRepository),
    )
)