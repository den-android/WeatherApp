package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.detail_forecast.model.CellFields
import net.denis.weatherapp.features.detail_forecast.model.IndicatorCellFields

@Composable
fun RowCellTextAndIndicator(
    modifier: Modifier = Modifier,
    cellFields: CellFields,
    indicatorCellFields: IndicatorCellFields,
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
                    cellFields = cellFields,
                    onCellClicked = { onCellClicked(cellFields.title) },
                    modifier = modifier.fillMaxWidth()
                )
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth()
            ) {
                CellWithIndicator(
                    indicatorCellFields = indicatorCellFields,
                    onCellClicked = { onCellClicked(indicatorCellFields.title) },
                    modifier = modifier.fillMaxWidth()
                )
            }
        }

    }


}

