package net.denis.weatherapp.features.forecast.screen.components

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.WeatherText
import net.denis.weatherapp.core.util.WeatherType
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CustomTextBox
import java.util.*

@Composable
fun CurrentWeatherInfoDisplay(
    modifier: Modifier = Modifier,
    city: String,
    temp: String,
    weatherDesc: String,
    currentDateTime: String,
    weatherIcon: Int,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = CityBackground),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = modifier
                .align(CenterHorizontally)
                .fillMaxWidth()
                .padding(
                    start = 40.dp,
                    end = 40.dp,
                    top = 48.dp,
                    bottom = 48.dp
                )
                .background(color = CityBackground),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround,
        ) {
            CustomTextBox(text = city)
            CustomTextBox(text = temp, size = 100)
            CustomTextBox(text = weatherDesc, color = WeatherText)
            CustomTextBox(text = currentDateTime)
        }
        Spacer(modifier.height(8.dp))
        Image(
            painter = painterResource(id = WeatherType.fromWMO(code = weatherIcon).iconRes),
            contentDescription = null,
            modifier = modifier.width(200.dp)
        )
    }
}