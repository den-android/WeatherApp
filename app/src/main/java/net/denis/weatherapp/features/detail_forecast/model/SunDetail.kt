package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable

data class SunDetail(
    val cityName: String,
    val sunrise: Int,
    val sunset: Int,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cityName)
        parcel.writeInt(sunrise)
        parcel.writeInt(sunset)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<SunDetail> {
        override fun createFromParcel(parcel: Parcel): SunDetail {
            return SunDetail(parcel)
        }

        override fun newArray(size: Int): Array<SunDetail?> {
            return arrayOfNulls(size)
        }
    }
}