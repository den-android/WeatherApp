package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText

@Composable
fun CustomTextBox(
    modifier: Modifier = Modifier,
    text: String,
    size: Int = 20,
    color: Color = PrimaryText,
) {
    Text(
        text = text,
        textAlign = TextAlign.Center,
        fontSize = size.sp,
        color = color,
        fontFamily = FontFamily.SansSerif
    )
}