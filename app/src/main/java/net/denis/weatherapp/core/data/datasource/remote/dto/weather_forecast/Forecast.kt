package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import com.google.gson.annotations.SerializedName
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.model.DetailItem
import net.denis.weatherapp.features.main_forecast.model.ForecastItem
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

data class Forecast(
    val clouds: Clouds,
    @SerializedName("dt")
    val dateTime: Int,
    @SerializedName("dt_txt")
    val dateTime_txt: String,
    val main: Main,
    @SerializedName("pop")
    val precipitation: Double,
    @SerializedName("sys")
    val dayOrNight: DayOrNight,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
)

fun Forecast.toForecastItem() = ForecastItem(
    dateTime = dtMap(dateTime),
    temp = main.toTemp(),
    meteorology = weather.map { it.toMeteorology() },
    detailData = toDetailData(),
)

fun Forecast.toDetailData() = DetailData(
    detailList = toDetailItem().toMultipleView()
)

fun Forecast.toDetailItem() = DetailItem(
    wind = wind,
    clouds = clouds,
    visibility = visibility
)

private fun dtMap(dt: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(dt.toLong() * 1000)
    return sdf.format(netDate)
}