package net.denis.weatherapp.features.forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.City
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FindNewCityScreen(
    modifier: Modifier = Modifier,
    vm: ForecastViewModel,
    city: String,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        TextField(
            value = city,
            onValueChange = vm::searchCity
        )
    }
}