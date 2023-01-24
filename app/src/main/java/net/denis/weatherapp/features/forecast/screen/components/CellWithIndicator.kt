package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CellWithIndicator(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    indicatorValue: Float,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .padding(4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = title, fontSize = 32.sp)
            Spacer(modifier = modifier.height(2.dp))
            Text(text = text, fontSize = 24.sp)
            Spacer(modifier = modifier.height(2.dp))
            LinearProgressIndicator(progress = indicatorValue)

        }
    }
}

@Preview(showBackground = true)
@Composable
fun testCell() {
    CellWithIndicator(title = "SUNRISE", text = "7:36", indicatorValue = 0.7f)
}