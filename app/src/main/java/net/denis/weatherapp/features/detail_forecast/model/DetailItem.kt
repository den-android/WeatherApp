package net.denis.weatherapp.features.detail_forecast.model

import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Clouds
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Wind
import net.denis.weatherapp.core.util.DetailModelCard
import java.math.RoundingMode
import java.text.SimpleDateFormat
import java.util.*

data class DetailItem(
    val cityDetail: CityDetail,
    val wind: Wind,
    val clouds: Clouds,
    val visibility: Int,
)
fun DetailItem.mapToUiCard(): List<DetailModelCard> {
    val cards = mutableListOf<DetailModelCard>()

    cards.add(
        DetailModelCard.WideCardWithText(
            indicatorCellFields = IndicatorCellFields(
                title = "Ветренность",
                text = "${roundSpeed(wind.speed)}м/с",
                indicatorValue = wind.speed.toFloat() / 10f,
                description = ""
            ),
        )
    )

    cards.add(
        DetailModelCard.CardWithTextAndText(
            leftCardWithText = DetailModelCard.CardWithText(
                cellFields = CellFields(
                    title = "Рассвет",
                    text = "${dtMap(cityDetail.sunrise)} AM",
                    description = "",
                )
            ),
            rightCardWithText = DetailModelCard.CardWithText(
                cellFields = CellFields(
                    title = "Закат",
                    text = "${dtMap(cityDetail.sunset)} PM",
                    description = ""
                )
            )
        )
    )

    cards.add(
        DetailModelCard.CardWithTextAndIndicator(
            cardWithText = DetailModelCard.CardWithText(
                cellFields = CellFields(
                    title = "Облачность",
                    text = "${clouds.all}%",
                    description = ""
                )
            ),
            cardWithIndicator = DetailModelCard.CardWithIndicator(
                indicatorCellFields = IndicatorCellFields(
                    title = "Видимость",
                    text = "",
                    indicatorValue = visibility / 10000f,
                    description = ""
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