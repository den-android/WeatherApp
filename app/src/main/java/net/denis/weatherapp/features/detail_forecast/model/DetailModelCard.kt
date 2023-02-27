package net.denis.weatherapp.features.detail_forecast.model

sealed interface DetailModelCard

data class CardWithText(val cellFields: CellFields) : DetailModelCard
data class CardWithIndicator(val cellFields: CellFields) : DetailModelCard

sealed class SingleCard : DetailModelCard {
    data class WideCardWithText(val card: DetailModelCard) : SingleCard()
}

sealed class DualCard : DetailModelCard {
    data class DualCardItem(
        val cardOne: DetailModelCard,
        val cardTwo: DetailModelCard,
    ) : DualCard()
}