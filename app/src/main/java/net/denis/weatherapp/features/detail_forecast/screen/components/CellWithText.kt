package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.presentation.ui.theme.ViewBackground
import net.denis.weatherapp.features.detail_forecast.model.CellFields

@Composable
fun CellWithText(
    modifier: Modifier = Modifier,
    cellFields: CellFields,
    onCellClicked: (String) -> Unit,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, MiddleGradientColor),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(12.dp)
            .clickable { onCellClicked(cellFields.title) }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(ViewBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = cellFields.title,
                fontSize = 22.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(2.dp))
            Text(
                text = cellFields.text,
                fontSize = 16.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(2.dp))
            Text(
                text = cellFields.description,
                fontSize = 14.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
        }
    }
}