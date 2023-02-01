package net.denis.weatherapp.features.forecast_at_three_hour.model

import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast_at_three_hour.model.items.CityDetail

data class TestDetailData(
    val cityDetail: CityDetail,
    val detailList: List<Detail>,
)
