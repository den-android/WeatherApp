package net.denis.weatherapp.features.main_forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.navigation.test.NavigationManager
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class MainStore @Inject constructor(
    navigationManager: NavigationManager,
    weatherRepository: IWeatherRepository,
) : BaseStore<MainState, MainAction>(
    initialState = MainState(),
    reducer = MainReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        MainDataMiddleware(
            navigationManager = navigationManager,
            weatherRepository = weatherRepository
        ),
    )
)