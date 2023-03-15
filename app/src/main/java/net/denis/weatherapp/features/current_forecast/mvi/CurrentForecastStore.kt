package net.denis.weatherapp.features.current_forecast.mvi

import net.denis.weatherapp.core.data.datasource.local.DataBuffer
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.navigation.NavigationManager
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class CurrentForecastStore @Inject constructor(
    navigationManager: NavigationManager,
    weatherRepository: IWeatherRepository,
    dataBuffer: DataBuffer
) : BaseStore<CurrentForecastState, CurrentForecastAction>(
    initialState = CurrentForecastState(),
    reducer = CurrentForecastReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        CurrentForecastDataMiddleware(
            navigationManager = navigationManager,
            weatherRepository = weatherRepository,
            dataBuffer = dataBuffer
        ),
    )
)