package net.denis.weatherapp.features.main_forecast.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.WeatherText
import net.denis.weatherapp.features.detail_forecast.screen.components.CustomTextBox
import net.denis.weatherapp.features.main_forecast.model.WeatherType

@Composable
fun CurrentWeatherDisplay(
    modifier: Modifier = Modifier,
    city: String,
    temp: String,
    weatherDesc: String,
    currentDateTime: String,
    weatherIcon: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                start = 40.dp,
                end = 40.dp,
                top = 48.dp,
                bottom = 48.dp
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly,
    ) {
        CustomTextBox(text = city)
        CustomTextBox(text = temp, size = 100)
        CustomTextBox(text = weatherDesc, color = WeatherText)
        CustomTextBox(text = currentDateTime)
        Spacer(modifier.height(8.dp))
        Image(
            painter = painterResource(id = WeatherType.fromWMO(code = weatherIcon).iconRes),
            contentDescription = null,
            modifier = modifier.width(200.dp)
        )
    }
}
