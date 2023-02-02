package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import net.denis.weatherapp.core.presentation.redux.State
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.temp.FinallyDetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.temp.FinallyDetailItem

data class DetailState(
    val isLoading: Boolean = false,
    val error: String? = null,
    //val detailData: DetailData? = null,
    val detailData: FinallyDetailItem? = null,
) : State