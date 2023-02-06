package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.detail_forecast.model.CellFields
import net.denis.weatherapp.features.detail_forecast.model.IndicatorCellFields

@Composable
fun RowCell(
    modifier: Modifier = Modifier,
    cellFields: CellFields,
    indicatorCellFields: IndicatorCellFields,
    onCellClicked: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Row {
            CellWithText(
                cellFields = cellFields,
                modifier = modifier.clickable { onCellClicked(cellFields.title) }
            )
            CellWithIndicator(
                indicatorCellFields = indicatorCellFields,
                modifier = modifier.clickable { onCellClicked(indicatorCellFields.title) }
            )
        }

    }

}