package net.denis.weatherapp.features.detail_forecast.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class DetailModelCard : Parcelable {

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