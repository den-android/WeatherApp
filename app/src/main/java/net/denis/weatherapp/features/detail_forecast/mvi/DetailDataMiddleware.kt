package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.features.detail_forecast.model.DetailData

class DetailDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<DetailState, DetailAction> {

    override suspend fun process(
        action: DetailAction,
        currentState: DetailState,
        store: Store<DetailState, DetailAction>
    ) {
        when (action) {
            is DetailAction.GetPosition -> {
                detailLoading(position = action.position, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun detailLoading(position: Int, store: Store<DetailState, DetailAction>) {

        val mappedData: DetailData = data.list[position].toDetailData()
        store.dispatch(DetailAction.DetailForecastLoaded(mappedData))

    }
}