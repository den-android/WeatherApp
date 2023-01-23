package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CurrentWeatherInfoDisplay(
    modifier: Modifier = Modifier,
) {
    Column {
        Text(text = "CURRENT CITY")
        Text(text = "CURRENT TEMP")
        Text(text = )
    }
}


@Composable
private fun ForecastIconDisplay(
    modifier: Modifier = Modifier,
    icon: Int,
) {
    Box() {

    }
}