package net.denis.weatherapp.features.detail_forecast.screen.components.card_type

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
    Column {
        Row {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(0.5f)
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
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
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
}