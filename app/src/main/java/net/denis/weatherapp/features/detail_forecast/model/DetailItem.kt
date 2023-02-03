package net.denis.weatherapp.features.detail_forecast.model

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Clouds
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Wind
import net.denis.weatherapp.core.util.MultipleView
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

data class DetailItem(
    val wind: Wind,
    val clouds: Clouds,
    val visibility: Int,
) {
    fun toMultipleView(): List<MultipleView> {
        val cards = mutableListOf<MultipleView>()

        cards.add(
            MultipleView.WideCardWithText(
                title = "Ветренность",
                text = "${roundSpeed(wind.speed)}м/с",
                indicatorValue = wind.speed.toFloat() / 10f,
                description = "",
            )
        )
        cards.add(
            MultipleView.WideCardWithText(
                title = "Ветренность",
                text = "${roundSpeed(wind.speed)}KM/CHAS",
                indicatorValue = wind.speed.toFloat() / 10f,
                description = "",
            )
        )
        cards.add(
            MultipleView.WideCardWithText(
                title = "Ветренность",
                text = "+++${roundSpeed(wind.speed)}+++",
                indicatorValue = wind.speed.toFloat() / 10f,
                description = "",
            )
        )

        cards.add(
            MultipleView.CardWithIndicator(
                title = "Видимость",
                text = "",
                indicatorValue = visibility / 10000f,
                description = "",
            )
        )

        cards.add(
            MultipleView.CardWithText(
                title = "Облачность",
                text = "${clouds.all}%",
                description = ""
            )
        )

        return cards
    }
}

private fun roundSpeed(windSpeed: Double): Double {
    return (windSpeed / 3.6f).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
}

private fun dtMap(value: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(value.plus(10800).toLong() * 1000)
    return sdf.format(netDate)
}