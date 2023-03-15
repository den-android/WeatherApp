package net.denis.weatherapp.features.detail_forecast.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.local.DataBuffer
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.features.detail_forecast.model.DetailData

class DetailDataMiddleware(
    private val dataBuffer: DataBuffer
) : Middleware<DetailState, DetailAction> {

    override suspend fun process(
        action: DetailAction,
        currentState: DetailState,
        store: Store<DetailState, DetailAction>
    ) {
        when (action) {
            is DetailAction.LoadingDetailData -> {
                store.dispatch(DetailAction.LoadedDetailData(detailData = dataBuffer.getData() as DetailData))
            }

            else -> currentState
        }
    }

}