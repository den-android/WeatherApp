package net.denis.weatherapp.features.forecast_at_three_hour.mvi

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
            is DetailAction.GetCurrentId -> {
                detailLoading(currentId = action.currentId, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun detailLoading(currentId: Int, store: Store<DetailState, DetailAction>) {
        weatherRepository.getForecast(
            lat = 55.7504461,
            lon = 37.6174943,
            apiKey = "b05865d24d90b1dbccfb3ced2627b4e9"
        ).collect { data ->

            val mappedData = data.list[currentId].toDetailData()


            store.dispatch(DetailAction.DetailForecastLoaded(mappedData))
        }
    }
}