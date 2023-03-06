package net.denis.weatherapp.features.detail_forecast.model

import androidx.annotation.Keep
import net.denis.weatherapp.R
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Clouds
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Wind
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

@Keep
data class DetailItem(
    val cityDetail: CityDetail,
    val wind: Wind,
    val clouds: Clouds,
    val visibility: Int,
)

fun DetailItem.mapToUiCard(): List<DetailModelCard> {
    val cards = mutableListOf<DetailModelCard>()


    cards.add(
        DualCard.DualCardItem(
            CardWithText(
                cellFields = CellFields(
                    title = "Рассвет",
                    text = "${dtMap(cityDetail.sunrise)} AM",
                    description = null,
                    indicatorValue = null,
                    icon = R.drawable.ic_sunrise
                )
            ),
            CardWithText(
                cellFields = CellFields(
                    title = "Закат",
                    text = "${dtMap(cityDetail.sunset)} PM",
                    description = null,
                    indicatorValue = null,
                    icon = R.drawable.ic_sunset
                )
            )
        )
    )

    cards.add(
        DualCard.DualCardItem(
            cardOne = CardWithText(
                cellFields = CellFields(
                    title = "Облачность",
                    text = "${clouds.all}%",
                    description = null,
                    indicatorValue = null,
                    icon = R.drawable.ic_clouds
                )
            ),
            cardTwo = CardWithIndicator(
                cellFields = CellFields(
                    title = "Видимость",
                    text = null,
                    indicatorValue = visibility / 10000f,
                    description = null,
                    icon = R.drawable.ic_visibility
                ),
            )
        )
    )

    cards.add(
        SingleCard.WideCardWithText(
            card = CardWithIndicator(
                cellFields = CellFields(
                    title = "Ветренность",
                    text = "${roundSpeed(wind.speed)}м/с",
                    indicatorValue = wind.speed.toFloat() / 10f,
                    description = null,
                    icon = R.drawable.ic_vector
                ),
            )
        )
    )

    return cards
}

private fun roundSpeed(windSpeed: Double): Double {
    return (windSpeed / 3.6f).toBigDecimal().setScale(1, RoundingMode.UP).toDouble()
}

private fun dtMap(value: Int): String {
    val sdf = SimpleDateFormat("HH:mm")
    val netDate = Date(value.plus(10800).toLong() * 1000)
    return sdf.format(netDate)
}