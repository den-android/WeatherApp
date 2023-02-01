package net.denis.weatherapp.features.forecast_at_three_hour.model

import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast_at_three_hour.model.items.CityDetail
import net.denis.weatherapp.features.forecast_at_three_hour.model.items.Cloud
import net.denis.weatherapp.features.forecast_at_three_hour.model.items.Wind
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

data class Detail(
    //val cityDetail: CityDetail,
    val cloud: Cloud,
    val wind: Wind,
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
                text = "${cloud.all}%",
                description = ""
            )
        )

        cards.add(
            MultipleView.CardWithText(
                title = "Рассвет",
                text = sunriseMap(5666666),
                description = ""
            )
        )

        cards.add(
            MultipleView.CardWithText(
                title = "Закат",
                text = sunsetMap(66666666),
                description = "",
            )
        )

        return cards
    }
}

private fun roundSpeed(windSpeed: Double): Double {
    return (windSpeed / 3.6f).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
}

private fun sunriseMap(sunrise: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(sunrise.plus(10800).toLong() * 1000)
    return sdf.format(netDate)
}

private fun sunsetMap(sunset: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(sunset.plus(10800).toLong() * 1000)
    return sdf.format(netDate)
}