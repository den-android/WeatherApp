package net.denis.weatherapp.features.detail_forecast.mvi

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityAction

sealed class DetailAction : Action {
    data class GetDetailData(val detailData: DetailData) : DetailAction()

    data class ShowError(val failureResponse: FailureResponse): DetailAction()
    object ClearErrorState: DetailAction()
}