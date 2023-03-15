package net.denis.weatherapp.features.detail_forecast.screen.components.card_type

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            .padding(16.dp)
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