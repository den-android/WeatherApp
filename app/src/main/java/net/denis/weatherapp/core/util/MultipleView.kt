package net.denis.weatherapp.core.util

sealed class MultipleView {

    data class WideCardWithText(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView()

    data class CardWithText(val title: String, val text: String, val description: String) : MultipleView()

    data class CardWithIndicator(val title: String, val text: String, val description: String, val indicatorValue: Float) : MultipleView()

}