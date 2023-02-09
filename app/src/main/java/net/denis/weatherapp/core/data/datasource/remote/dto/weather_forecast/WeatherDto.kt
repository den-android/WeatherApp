package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import net.denis.weatherapp.features.detail_forecast.model.CityDetail
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.detail_forecast.model.DetailItem
import net.denis.weatherapp.features.detail_forecast.model.mapToUiCard
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.ForecastItem
import java.text.SimpleDateFormat
import java.util.*

@Keep
data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    @SerializedName("list")
    val forecast: List<Forecast>,
    val message: Int
) {
    fun WeatherDto.toCityDetail() = CityDetail(
        cityName = city.name,
        sunrise = city.sunrise,
        sunset = city.sunset,
    )

    fun Forecast.toDetailItem() = DetailItem(
        cityDetail = toCityDetail(),
        wind = wind,
        clouds = clouds,
        visibility = visibility
    ).mapToUiCard()

    fun Forecast.toDetailData() = DetailData(
        cityDetail = toCityDetail(),
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
    cityDetail = toCityDetail(),
    forecastList = forecast.map { it.toForecastItem() }
)

private fun dtMap(dt: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(dt.toLong() * 1000)
    return sdf.format(netDate)
}


