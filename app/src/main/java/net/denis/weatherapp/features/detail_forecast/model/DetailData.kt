package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable
import net.denis.weatherapp.core.util.DetailModelCard

data class DetailData(
    val sunDetail: SunDetail,
    val detailList: List<DetailModelCard>,
): Parcelable {
    constructor(parcel: Parcel) : this(
        sunDetail = parcel.readValue(SunDetail::class.java.classLoader) as SunDetail,
        detailList = parcel.readValue(DetailModelCard::class.java.classLoader) as List<DetailModelCard>
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(sunDetail)
        parcel.writeValue(detailList)
    }

    companion object CREATOR : Parcelable.Creator<DetailData> {
        override fun createFromParcel(parcel: Parcel): DetailData {
            return DetailData(parcel)
        }

        override fun newArray(size: Int): Array<DetailData?> {
            return arrayOfNulls(size)
        }
    }
}