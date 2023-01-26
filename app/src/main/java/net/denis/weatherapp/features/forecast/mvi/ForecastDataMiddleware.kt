package net.denis.weatherapp.features.forecast.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMap
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast.model.MultipleView

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
        weatherRepository.getForecast(lat = 55.7504461, lon = 37.6174943, exclude = "alerts", apiKey = "b05865d24d90b1dbccfb3ced2627b4e9")
            .collect { data ->
                
            }

    }
//        weatherRepository.getForecast(lat = 55.7504461, lon = 37.6174943, exclude = "alerts", apiKey = "b05865d24d90b1dbccfb3ced2627b4e9",)
//
//            .collect { data ->
//
//
//                val mappedData: MultipleView<MeteorologyItem> = data
//                store.dispatch(ForecastAction.ForecastLoaded(meteorologyItem = mappedData))
//            }
//    }

}


//store.dispatch(ForecastAction.ForecastLoaded(meteorologyItem = mappedData))