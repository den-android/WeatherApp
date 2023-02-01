package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import net.denis.weatherapp.features.core.Forecast
import net.denis.weatherapp.features.forecast.model.ForecastData
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.TestDetailData

data class WeatherDto(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: kotlin.collections.List<List>,
    val message: Int
) {
    private fun toForecastData(): ForecastData {
        return ForecastData(
            city = city.toCityDetail(),
            forecastItem = list.map { it.toForecast() }
        )
    }

    private fun toDetailData(): DetailData {
        return DetailData(
            detailList = list.map { it.toDetail() }
        )
    }

    fun toForecast(): Forecast {
        return Forecast(
            mainData = toForecastData(),
            detailData = toDetailData(),
        )
    }


    private fun toTestDetailData(): TestDetailData {
        return TestDetailData(
            cityDetail = city.toCityDetail(),
            detailList = list.map { it.toDetail() }
        )
    }
}