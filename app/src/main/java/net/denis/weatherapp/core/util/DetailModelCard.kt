package net.denis.weatherapp.core.util

import net.denis.weatherapp.features.detail_forecast.model.CellFields
import net.denis.weatherapp.features.detail_forecast.model.IndicatorCellFields

sealed class DetailModelCard {

    data class WideCardWithText(val indicatorCellFields: IndicatorCellFields) : DetailModelCard()

    data class CardWithText(val cellFields: CellFields) : DetailModelCard()

    data class CardWithIndicator(val indicatorCellFields: IndicatorCellFields) : DetailModelCard()

    data class CardWithTextAndIndicator(
        val cardWithText: CardWithText,
        val cardWithIndicator: CardWithIndicator,
    ) : DetailModelCard()
    
    data class CardWithTextAndText(
        val leftCardWithText: CardWithText,
        val rightCardWithText: CardWithText,
    ) : DetailModelCard()

}