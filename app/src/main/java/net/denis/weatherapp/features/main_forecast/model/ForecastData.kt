package net.denis.weatherapp.features.main_forecast.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import net.denis.weatherapp.features.detail_forecast.model.CityDetail

@Keep
data class ForecastData(
    val cityDetail: CityDetail,
    val forecastList: List<ForecastItem>,
) : Parcelable {
    constructor(parcel: Parcel) : this(
        cityDetail = parcel.readValue(CityDetail::class.java.classLoader) as CityDetail,
        forecastList = parcel.readValue(ForecastItem::class.java.classLoader) as List<ForecastItem>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(cityDetail, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<ForecastData> {
        override fun createFromParcel(parcel: Parcel): ForecastData {
            return ForecastData(parcel)
        }

        override fun newArray(size: Int): Array<ForecastData?> {
            return arrayOfNulls(size)
        }
    }

}