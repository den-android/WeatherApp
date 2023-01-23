package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import net.denis.weatherapp.R
import net.denis.weatherapp.features.forecast.screen.components.ForecastIconDisplay

@Preview
@Composable
private fun showCityDetailScreen(){
    CityDetailScreen()
}

@Composable
fun CityDetailScreen(

) {
    ForecastIconDisplay(icon = R.drawable.ic_cloudy)
}
