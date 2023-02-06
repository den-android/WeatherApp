package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import net.denis.weatherapp.core.util.MultipleView

@Parcelize
data class DetailData(
    val detailList: @RawValue List<MultipleView>,
): Parcelable
