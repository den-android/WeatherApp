package net.denis.weatherapp.features.fetch_new_city.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

@Keep
data class CityData(
    val name: String,
    val lat: Double,
    val lon: Double
) : Parcelable {

    constructor(parcel: Parcel) : this(
        name = parcel.readString() ?: "",
        lat = parcel.readDouble(),
        lon = parcel.readDouble()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeDouble(lat)
        parcel.writeDouble(lon)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CityData> {
        override fun createFromParcel(parcel: Parcel): CityData {
            return CityData(parcel)
        }

        override fun newArray(size: Int): Array<CityData?> {
            return arrayOfNulls(size)
        }
    }
}
