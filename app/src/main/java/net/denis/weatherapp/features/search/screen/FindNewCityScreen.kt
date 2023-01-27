package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindNewCityScreen(
    modifier: Modifier = Modifier,
    city: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(city)
    }
}