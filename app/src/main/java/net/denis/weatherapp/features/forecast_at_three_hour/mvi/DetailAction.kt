package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast.model.ForecastData
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.temp.FinallyDetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.temp.FinallyDetailItem

sealed class DetailAction : Action {
    data class GetCurrentId(val currentId: Int): DetailAction()
    //data class DetailForecastLoaded(val detailData: DetailData) : DetailAction()
    //data class DetailMapping(val detailData: List<MultipleView>) : DetailAction()
    data class DetailForecastLoaded(val forecastData: FinallyDetailItem) : DetailAction()
}