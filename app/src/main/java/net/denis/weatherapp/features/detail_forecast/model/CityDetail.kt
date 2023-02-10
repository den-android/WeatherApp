package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable

data class CityDetail(
    val cityName: String,
    val sunrise: Int,
    val sunset: Int,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        cityName = parcel.readString() ?: "",
        sunrise = parcel.readInt(),
        sunset = parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cityName)
        parcel.writeInt(sunrise)
        parcel.writeInt(sunset)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CityDetail> {
        override fun createFromParcel(parcel: Parcel): CityDetail {
            return CityDetail(parcel)
        }

        override fun newArray(size: Int): Array<CityDetail?> {
            return arrayOfNulls(size)
        }
    }
}