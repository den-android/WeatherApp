package net.denis.weatherapp.features.detail_forecast.screen.components.card_type

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.detail_forecast.model.CardWithIndicator
import net.denis.weatherapp.features.detail_forecast.model.CardWithText
import net.denis.weatherapp.features.detail_forecast.model.DetailModelCard
import net.denis.weatherapp.features.detail_forecast.screen.components.CellUi

@Composable
fun SingleCardUi(
    modifier: Modifier = Modifier,
    card: DetailModelCard,
    onCellClicked: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        when (card) {
            is CardWithIndicator -> {
                CellUi(cell = card.cellFields, onCellClick = { onCellClicked(it) })
            }
            is CardWithText -> {
                CellUi(cell = card.cellFields, onCellClick = { onCellClicked(it) })
            }
            else -> {}
        }
    }

}