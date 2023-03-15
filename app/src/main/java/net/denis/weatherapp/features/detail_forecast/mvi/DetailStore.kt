package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.data.datasource.local.DataBuffer
import net.denis.weatherapp.core.presentation.redux.BaseStore
import javax.inject.Inject

class DetailStore @Inject constructor(
    dataBuffer: DataBuffer
) : BaseStore<DetailState, DetailAction>(
    initialState = DetailState(),
    reducer = DetailReducer(),
    middlewares = listOf(
        //LoggingMiddleware(),
        DetailDataMiddleware(
            dataBuffer = dataBuffer
        )
    )
)