package net.denis.weatherapp.core.util

import net.denis.weatherapp.features.detail_forecast.model.CellFields
import net.denis.weatherapp.features.detail_forecast.model.IndicatorCellFields

sealed class ViewType {

    data class WideCardWithText(val indicatorCellFields: IndicatorCellFields) : ViewType()

    data class CardWithText(val cellFields: CellFields) : ViewType()

    data class CardWithIndicator(val indicatorCellFields: IndicatorCellFields) : ViewType()

    data class RowCardItem(
        val cardWithText: CardWithText,
        val cardWithIndicator: CardWithIndicator,
    ) : ViewType()

}