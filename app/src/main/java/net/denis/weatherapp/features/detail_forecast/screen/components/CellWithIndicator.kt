package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.features.detail_forecast.model.IndicatorCellFields

@Composable
fun CellWithIndicator(
    modifier: Modifier = Modifier,
    indicatorCellFields: IndicatorCellFields
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(1.dp, MiddleGradientColor),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp)
                .background(CityBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = indicatorCellFields.title,
                fontSize = 22.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(2.dp))
            Text(
                text = indicatorCellFields.text,
                fontSize = 16.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = modifier.height(2.dp))
            CustomLPB(indicatorValue = indicatorCellFields.indicatorValue)
            Spacer(modifier = modifier.height(2.dp))
            Text(
                text = indicatorCellFields.description,
                fontSize = 14.sp,
                color = PrimaryText,
                textAlign = TextAlign.Center,
            )
        }
    }
}
