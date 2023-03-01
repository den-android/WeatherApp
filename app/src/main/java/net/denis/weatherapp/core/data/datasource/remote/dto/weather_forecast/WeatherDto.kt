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
    fun WeatherDto.mapToCityDetail() = CityDetail(
        cityName = city.name,
        sunrise = city.sunrise,
        sunset = city.sunset,
    )

    private fun Forecast.mapToDetailItem() = DetailItem(
        cityDetail = mapToCityDetail(),
        wind = wind,
        clouds = clouds,
        visibility = visibility
    ).mapToUiCard()

    private fun Forecast.mapToDetailData() = DetailData(
        cityDetail = mapToCityDetail(),
        detailList = mapToDetailItem()
    )

    fun Forecast.mapToForecastItem() = ForecastItem(
        dateTime = dtMap(dateTime),
        temp = main.mapToTemp(),
        meteorology = weather.map { it.toMeteorology() },
        detailData = mapToDetailData(),
    )
}

fun WeatherDto.mapToForecastData() = ForecastData(
    cityDetail = mapToCityDetail(),
    forecastList = forecast.map { it.mapToForecastItem() }
)

private fun dtMap(dt: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(dt.toLong() * 1000)
    return sdf.format(netDate)
}


