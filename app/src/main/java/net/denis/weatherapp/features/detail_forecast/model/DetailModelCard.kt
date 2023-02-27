package net.denis.weatherapp.features.detail_forecast.model

sealed interface DetailModelCard

sealed class SingleCard : DetailModelCard {
    data class WideCardWithText(val cellFields: CellFields) : SingleCard()
    data class CardWithText(val cellFields: CellFields) : SingleCard()
    data class CardWithIndicator(val cellFields: CellFields) : SingleCard()
}

sealed class DualCard : DetailModelCard {
    data class Custom(
        val cardOne: DetailModelCard,
        val cardTwo: DetailModelCard,
    ) : DualCard()
}