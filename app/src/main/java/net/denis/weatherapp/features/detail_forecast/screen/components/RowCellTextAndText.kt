package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.detail_forecast.model.CellFields

@Composable
fun RowCellTextAndText(
    modifier: Modifier = Modifier,
    leftCellFields: CellFields,
    rightCellFields: CellFields,
    onCellClicked: (String) -> Unit,
) {
    Column {
        Row {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(0.5f)
            ) {
                CellWithText(
                    cellFields = leftCellFields,
                    onCellClicked = { onCellClicked(leftCellFields.title) }
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                CellWithText(
                    cellFields = rightCellFields,
                    onCellClicked = { onCellClicked(rightCellFields.title) }
                )
            }
        }

    }

}