package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.core.Forecast
import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
) {
    private fun toWeatherItem(): MeteorologyItem {
        return MeteorologyItem(
            city = city.toCity(),
            forecastMain = list.map { it.toForecast() }
        )
    }

    private fun toDetailDataItem(): DetailData {
        return DetailData(
            detailList = list.map { it.toDetail() }
        )
    }

    fun toForecast(): Forecast {
        return Forecast(
            mainData = toWeatherItem(),
            detailData = toDetailDataItem(),
        )
    }

}