package net.denis.weatherapp.features.main_forecast.model

import android.os.Parcel
import android.os.Parcelable
import net.denis.weatherapp.features.detail_forecast.model.DetailData

data class ForecastItem(
    val dateTime: String,
    val meteorology: List<Meteorology>,
    val temp: String,
    val detailData: DetailData,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        dateTime = parcel.readString() ?: "",
        meteorology = parcel.readValue(Meteorology::class.java.classLoader) as List<Meteorology>,
        temp = parcel.readString() ?: "",
        detailData = parcel.readValue(DetailData::class.java.classLoader) as DetailData
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(dateTime)
        parcel.writeTypedList(meteorology)
        parcel.writeString(temp)
        parcel.writeParcelable(detailData, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ForecastItem> {
        override fun createFromParcel(parcel: Parcel): ForecastItem {
            return ForecastItem(parcel)
        }

        override fun newArray(size: Int): Array<ForecastItem?> {
            return arrayOfNulls(size)
        }
    }

}