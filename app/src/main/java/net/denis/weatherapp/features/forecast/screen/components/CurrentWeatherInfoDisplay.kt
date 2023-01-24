package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.Weather
import net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast.WeatherDto
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.presentation.ui.theme.WeatherText
import net.denis.weatherapp.core.util.WeatherType

@Composable
fun CurrentWeatherInfoDisplay(
    modifier: Modifier = Modifier,
    city: String,
    temp: Double,
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
            CustomTextBox(text = "${temp}°", size = 120)
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

@Composable
private fun CustomTextBox(
    modifier: Modifier = Modifier,
    text: String,
    size: Int? = null ?: 20,
    color: Color? = null ?: PrimaryText,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        color = color!!,
        fontSize = size!!.sp,
        fontFamily = FontFamily.SansSerif,
        modifier = modifier
            .background(CityBackground)
    )
}

//@Preview(showBackground = true)
//@Composable
//fun ShowCurrentWeatherInfoDisplay() {
//    CurrentWeatherInfoDisplay(
//        city = "Moscow",
//        temp = "20",
//        weather = "Overcast cloud",
//        weatherIcon = 801,
//    )
//}