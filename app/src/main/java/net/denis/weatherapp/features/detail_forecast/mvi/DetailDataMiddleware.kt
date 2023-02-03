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
            is DetailAction.GetCurrentId -> {
                detailLoading(currentId = action.currentId, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun detailLoading(currentId: Int, store: Store<DetailState, DetailAction>) {

        val mappedData: DetailData = data.list[currentId].toDetailData()
        store.dispatch(DetailAction.DetailForecastLoaded(mappedData))

    }
}