package net.denis.weatherapp.features.forecast.screen.components

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.ActivedCard
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.util.WeatherType
import net.denis.weatherapp.features.forecast.model.ForecastItem
import net.denis.weatherapp.features.forecast.model.Main
import net.denis.weatherapp.features.forecast.model.Meteorology
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.*

@Composable
fun HourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    forecastItem: ForecastItem,
    meteorology: Meteorology,
    main: Main,
) {
    val activeCard = remember(Color) {
        val sdf = SimpleDateFormat("HH:mm")
        val localDateTime = ZonedDateTime
            .now(ZoneId.of("Europe/Moscow"))
            .format(DateTimeFormatter.ofPattern("HH:mm"))

        val apiTime = sdf.format(Date(forecastItem.dt.toLong() * 1000))
        val apiTimePlus3H = sdf.format(Date((forecastItem.dt.plus(10799).toLong()) * 1000))

        if (localDateTime > apiTime && localDateTime < apiTimePlus3H) {
            ActivedCard
        } else {
            CityBackground
        }
    }

    val formattedTime = remember(String) {
        val sdf = SimpleDateFormat("HH:mm")
        val localDateTime = ZonedDateTime
            .now(ZoneId.of("Europe/Moscow"))
            .format(DateTimeFormatter.ofPattern("HH:mm"))
        val apiTime = sdf.format(Date(forecastItem.dt.toLong() * 1000))
        apiTime
    }

    Box(
        modifier = modifier
            .border(width = 1.dp, color = Color.LightGray)
            .background(activeCard)
    ) {
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
                painter = painterResource(id = WeatherType.fromWMO(code = meteorology.id).iconRes),
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
}

private fun roundTemp(temp: Double): Double {
    val df = DecimalFormat("##", DecimalFormatSymbols(Locale.ENGLISH))
    return df.format(temp.toBigDecimal()).toDouble()
}