package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class DetailAction : Action {
    data class GetPosition(val position: Int): DetailAction()
    data class DetailForecastLoaded(val detailData: DetailData) : DetailAction()
    //data class DetailMapping(val detailData: List<MultipleView>) : DetailAction()
}