package net.denis.weatherapp.features.main_forecast.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

@Keep
data class Meteorology(
    val id: Int,
    val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        id = parcel.readInt(),
        description = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(description)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Meteorology> {
        override fun createFromParcel(parcel: Parcel): Meteorology {
            return Meteorology(parcel)
        }

        override fun newArray(size: Int): Array<Meteorology?> {
            return arrayOfNulls(size)
        }
    }
}
