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
            is DetailAction.GetDetailData -> {
                detailLoading(detailData = action.detailData, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun detailLoading(detailData: DetailData, store: Store<DetailState, DetailAction>) {
        store.dispatch(DetailAction.DetailDataLoaded(detailData))
    }
}