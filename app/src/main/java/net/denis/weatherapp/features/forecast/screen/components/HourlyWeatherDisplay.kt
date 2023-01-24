package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.List
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Main
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.util.WeatherType

@Composable
fun HourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    list: List,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = list.dt_txt,
            color = Color.LightGray
        )
        Image(
            painter = painterResource(id = WeatherType.fromWMO(code = list.weather.get(0).id).iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${list.main.temp}°C",
            color = PrimaryText,
            fontWeight = FontWeight.Bold
        )
    }
}
