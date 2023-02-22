package net.denis.weatherapp.features.fetch_new_city.screen.components

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
import net.denis.weatherapp.features.fetch_new_city.model.CityData

@Composable
fun ResponseTextBox(
    modifier: Modifier = Modifier,
    cityData: CityData,
    onItemClick: () -> Unit,
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        border = BorderStroke(2.dp, MiddleGradientColor),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(12.dp)
            .clickable { onItemClick() }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(ViewBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(
                text = cityData.name,
                color = PrimaryText,
                fontSize = 32.sp,
                textAlign = TextAlign.Center,
            )
        }

    }
}