package net.denis.weatherapp.features.forecast_at_three_hour.model

sealed class MultipleView<T: Any> {

    data class WideCardWithText<T: Any>(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView<T>()

    data class CardWithText<T: Any>(val title: String, val text: String, val description: String) : MultipleView<T>()

    data class CardWithIndicator<T: Any>(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView<T>()

    data class DefaultCard<T: Any>(val title: String, val text: String) : MultipleView<T>()
}