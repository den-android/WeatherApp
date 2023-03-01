package net.denis.weatherapp.features.main_forecast.model

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import net.denis.weatherapp.features.detail_forecast.model.CityDetail

@Keep
data class ForecastData(
    val cityDetail: CityDetail,
    val forecast: ForecastItem,
    val hourlyList: List<HourlyModelCard>
)