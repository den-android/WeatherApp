package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.core.util.MultipleView

sealed class DetailAction : Action {
    data class GetCurrentId(val currentId: Int): DetailAction()
    data class DetailForecastLoaded(val detail: List<MultipleView<Detail>>) : DetailAction()
}