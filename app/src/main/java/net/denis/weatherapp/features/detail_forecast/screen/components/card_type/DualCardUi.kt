package net.denis.weatherapp.features.detail_forecast.screen.components.card_type

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.features.detail_forecast.model.CardWithIndicator
import net.denis.weatherapp.features.detail_forecast.model.CardWithText
import net.denis.weatherapp.features.detail_forecast.model.DetailModelCard
import net.denis.weatherapp.features.detail_forecast.screen.components.CellUi

@Composable
fun DualCardUi(
    modifier: Modifier = Modifier,
    leftCard: DetailModelCard,
    rightCard: DetailModelCard,
    onCellClicked: (String) -> Unit,
) {
    Row(modifier = modifier.padding(16.dp)) {
        Row(
            modifier = modifier
                .fillMaxWidth(0.5f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (leftCard) {
                is CardWithIndicator -> {
                    CellUi(
                        cell = leftCard.cellFields,
                        onCellClick = { onCellClicked(it) })
                }
                is CardWithText -> {
                    CellUi(
                        cell = leftCard.cellFields,
                        onCellClick = { onCellClicked(it) })
                }
                else -> {}
            }
        }
        Spacer(modifier = modifier.padding(horizontal = 4.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            when (rightCard) {
                is CardWithIndicator -> {
                    CellUi(
                        cell = rightCard.cellFields,
                        onCellClick = { onCellClicked(it) })
                }
                is CardWithText -> {
                    CellUi(
                        cell = rightCard.cellFields,
                        onCellClick = { onCellClicked(it) })
                }
                else -> {}
            }
        }

    }
}