package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.util.WeatherType
import net.denis.weatherapp.features.forecast.model.ForecastItem
import net.denis.weatherapp.features.forecast.model.Meteorology

@Composable
fun HourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    forecastItem: ForecastItem,
//    meteorology: Meteorology,
//    temp: String,
) {
    Box(
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray)
            .background(CityBackground)
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = forecastItem.dateTime,
                color = PrimaryText
            )
            Image(
                painter = painterResource(id = WeatherType.fromWMO(code = forecastItem.meteorology[0].id).iconRes),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = forecastItem.temp,
                color = PrimaryText,
                fontWeight = FontWeight.Bold
            )
        }
    }
}