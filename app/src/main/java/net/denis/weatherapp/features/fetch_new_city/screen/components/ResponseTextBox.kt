package net.denis.weatherapp.features.fetch_new_city.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.CellBorderColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.features.fetch_new_city.model.CityData

@Composable
fun ResponseTextBox(
    modifier: Modifier = Modifier,
    cityName: String,
    onItemClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(12.dp)
            .clickable { onItemClick() }
            .clip(RoundedCornerShape(15))
            .border(
                border = BorderStroke(width = 1.dp, color = CellBorderColor),
                shape = RoundedCornerShape(15)
            )
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = cityName,
                color = PrimaryText,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
            )
        }

    }
}