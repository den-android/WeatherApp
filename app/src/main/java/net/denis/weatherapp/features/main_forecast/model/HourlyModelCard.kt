package net.denis.weatherapp.features.main_forecast.model

sealed class HourlyModelCard {
    data class CurrentHourlyCard(val hourlyItem: HourlyItem) : HourlyModelCard()
    data class HourlyCard(val hourlyItem: HourlyItem) : HourlyModelCard()
}