package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class MainStore @Inject constructor(
    weatherRepository: IWeatherRepository,
) : BaseStore<MainState, MainAction>(
    initialState = MainState(),
    reducer = MainReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        MainDataMiddleware(weatherRepository),
    )
)