package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class DetailAction : Action {
    data class GetDetailData(val detailData: DetailData) : DetailAction()
}