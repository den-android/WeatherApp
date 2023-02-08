package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class CellFields(
    val title: String,
    val text: String,
    val description: String
): Parcelable {

    private constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(description)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<CellFields> {
        override fun createFromParcel(parcel: Parcel): CellFields {
            return CellFields(parcel)
        }

        override fun newArray(size: Int): Array<CellFields?> {
            return arrayOfNulls(size)
        }
    }
}
