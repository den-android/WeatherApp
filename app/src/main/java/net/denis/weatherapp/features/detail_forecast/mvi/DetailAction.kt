package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.detail_forecast.model.DetailData

sealed class DetailAction : Action {

    object LoadingDetailData : DetailAction()
    data class LoadedDetailData(val detailData: DetailData) : DetailAction()
}