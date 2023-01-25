package net.denis.weatherapp.features.forecast.screen.components

import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor

@Composable
fun CustomLPB(
    modifier: Modifier = Modifier,
    indicatorValue: Float,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        CustomLinearProgressBar(
            percentage = indicatorValue,
        )
    }
}

@Composable
fun CustomLinearProgressBar(
    modifier: Modifier = Modifier,
    percentage: Float,
) {
    Box(
        modifier = modifier
            .background(CityBackground)
    ) {
        Canvas(
            modifier = modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            drawLine(
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = 0f),
                strokeWidth = 15F,
                color = Color.Magenta,
                cap = StrokeCap.Round,
            )
            var x: Float = size.width * percentage
            var y: Float = 0f
            drawCircle(
                color = Color.White,
                radius = 15f,
                center = Offset(x, y)
            )
        }
    }

}