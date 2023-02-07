package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import com.google.gson.annotations.SerializedName
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.model.DetailItem
import net.denis.weatherapp.features.detail_forecast.model.SunDetail
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.ForecastItem
import java.text.SimpleDateFormat
import java.util.*

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    @SerializedName("list")
    val forecast: List<Forecast>,
    val message: Int
) {
    fun WeatherDto.toSunDetail() = SunDetail(
        cityName = city.name,
        sunrise = city.sunrise,
        sunset = city.sunset,
    )

    fun Forecast.toDetailItem() = DetailItem(
        sunDetail = toSunDetail(),
        wind = wind,
        clouds = clouds,
        visibility = visibility
    ).toMultipleView()

    fun Forecast.toDetailData() = DetailData(
        sunDetail = toSunDetail(),
        detailList = toDetailItem()
    )

    fun Forecast.toForecastItem() = ForecastItem(
        dateTime = dtMap(dateTime),
        temp = main.toTemp(),
        meteorology = weather.map { it.toMeteorology() },
        detailData = toDetailData(),
    )
}

fun WeatherDto.toForecastData() = ForecastData(
    sunDetail = toSunDetail(),
    forecastList = forecast.map { it.toForecastItem() }
)

private fun dtMap(dt: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(dt.toLong() * 1000)
    return sdf.format(netDate)
}


