package net.denis.weatherapp.features.forecast.screen.components

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.List
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Main
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Weather
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.util.WeatherType
import java.util.*

@Composable
fun HourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    main: Main,
    list: List,
    weather: Weather,
) {
    val formattedTime = remember(list.dt) {
        val sdf = SimpleDateFormat("HH:mm")
        val netDate = Date(list.dt.toLong() * 1000)
        sdf.format(netDate)
    }

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = formattedTime,
            color = PrimaryText
        )
        Image(
            painter = painterResource(id = WeatherType.fromWMO(code = weather.id).iconRes),
            contentDescription = null,
            modifier = Modifier.width(40.dp)
        )
        Text(
            text = "${main.temp}°C",
            color = PrimaryText,
            fontWeight = FontWeight.Bold
        )
    }
}