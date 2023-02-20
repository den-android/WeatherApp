package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable

data class DetailData(
    val cityDetail: CityDetail,
    val detailList: List<DetailModelCard>,
): Parcelable {
    constructor(parcel: Parcel) : this(
        cityDetail = parcel.readValue(CityDetail::class.java.classLoader) as CityDetail,
        detailList = parcel.readValue(DetailItem::class.java.classLoader) as List<DetailModelCard>
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(cityDetail)
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