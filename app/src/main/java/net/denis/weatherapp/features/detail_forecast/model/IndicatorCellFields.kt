package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep

@Keep
data class IndicatorCellFields(
    val title: String,
    val text: String,
    val description: String,
    val indicatorValue: Float,
) : Parcelable {

    constructor(parcel: Parcel) : this(
        title = parcel.readString() ?: "",
        text = parcel.readString() ?: "",
        description = parcel.readString() ?: "",
        indicatorValue = parcel.readFloat(),
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(text)
        parcel.writeString(description)
        parcel.writeFloat(indicatorValue)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<IndicatorCellFields> {
        override fun createFromParcel(parcel: Parcel): IndicatorCellFields {
            return IndicatorCellFields(parcel)
        }

        override fun newArray(size: Int): Array<IndicatorCellFields?> {
            return arrayOfNulls(size)
        }
    }
}
