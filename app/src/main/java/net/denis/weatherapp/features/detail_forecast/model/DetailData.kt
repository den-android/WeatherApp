package net.denis.weatherapp.features.detail_forecast.model

import androidx.annotation.Keep

@Keep
data class DetailData(
    val cityDetail: CityDetail,
    val detailList: List<DetailModelCard>,
)