package net.denis.weatherapp.features.current_forecast.model

import androidx.annotation.Keep
import net.denis.weatherapp.features.detail_forecast.model.CityDetail

@Keep
data class ForecastData(
    val cityDetail: CityDetail,
    val forecast: ForecastItem,
    val hourlyList: List<HourlyModelCard>
)