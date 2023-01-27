package net.denis.weatherapp.features.forecast_at_three_hour.model

sealed class MultipleView {

    data class WideCardWithText(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView()

    data class CardWithText(val title: String) : MultipleView()

    data class CardWithIndicator(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView()

    data class DefaultCard(val title: String, val text: String) : MultipleView()
}