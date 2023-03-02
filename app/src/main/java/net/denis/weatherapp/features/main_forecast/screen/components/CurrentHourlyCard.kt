package net.denis.weatherapp.features.main_forecast.screen.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.CurrentCardColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.features.main_forecast.model.HourlyItem
import net.denis.weatherapp.features.main_forecast.model.WeatherType

@Composable
fun CurrentHourlyWeatherDisplay(
    modifier: Modifier = Modifier,
    hourlyItem: HourlyItem,
    onRangeClicked: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .border(
                border = BorderStroke(width = 1.dp, color = Color.LightGray),
                shape = RoundedCornerShape(50)
            )
            .background(CurrentCardColor)
            .clickable { onRangeClicked() }
    ) {
        Column(
            modifier = modifier
                .width(80.dp)
                .padding(4.dp)
                .height(140.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = hourlyItem.dateTime,
                color = Color.DarkGray
            )
            Image(
                painter = painterResource(id = WeatherType.fromWMO(code = hourlyItem.meteorology[0].id).iconRes),
                contentDescription = null,
                modifier = Modifier.width(40.dp)
            )
            Text(
                text = hourlyItem.temp,
                color = Color.DarkGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}