package net.denis.weatherapp.features.forecast.screen.components.compose_items

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText

@Composable
fun CellWithText(
    modifier: Modifier = Modifier,
    title: String = "VISIBILITY",
    text: String = "Main text",
    description: String = "descyyyy"
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(4.dp)
                .background(CityBackground),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 32.sp,
                color = PrimaryText,
            )
            Text(
                text = text,
                fontSize = 24.sp,
                color = PrimaryText,
            )
            Text(
                text = description,
                fontSize = 16.sp,
                color = PrimaryText,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showTest() {
    CellWithText()
}