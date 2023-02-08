package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import net.denis.weatherapp.core.util.DetailModelCard

@Parcelize
data class DetailData(
    val sunDetail: @RawValue SunDetail,
    val detailList: @RawValue List<DetailModelCard>,
) : Parcelable