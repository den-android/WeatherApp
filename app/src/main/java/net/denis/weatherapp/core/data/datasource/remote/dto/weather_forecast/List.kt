package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.forecast.model.ForecastItem
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailItem
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.List

data class List(
    val clouds: Clouds,
    val dt: Int,
    val dt_txt: String,
    val main: Main,
    val pop: Double,
    val sys: Sys,
    val visibility: Int,
    val weather: List<Weather>,
    val wind: Wind
) {
    fun toForecastItem(): ForecastItem {
        return ForecastItem(
            dateTime = dtMap(dt),
            temp = main.toTemp(),
            meteorology = weather.map { it.toMeteorology() },
            detailData = toDetailData(),
        )
    }

    fun toDetailData(): DetailData {
        return DetailData(
            detailItem = toDetailItem().toMultipleView()
        )
    }

    fun toDetailItem(): DetailItem {
        return DetailItem(
            wind = wind,
            clouds = clouds,
            visibility = visibility
        )
    }

}

fun dtMap(dt: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(dt.toLong() * 1000)
    return sdf.format(netDate)
}