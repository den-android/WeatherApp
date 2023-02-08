package net.denis.weatherapp.features.main_forecast.screen.components

import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground

@Composable
fun ShimmerMainScreen(
    modifier: Modifier = Modifier,
    isLoading: Boolean,
    contentAfterLoading: @Composable () -> Unit,
) {
    if (isLoading) {
        Column(
            modifier = modifier
                .background(CityBackground)
                .fillMaxSize()
        ) {
            Box(
                modifier = modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(16.dp)
                    .shimmerEffect()
            )
            Row(
                modifier = modifier.padding(16.dp)
            ) {
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .weight(0.4f)
                        .shimmerEffect()
                )
                Spacer(modifier = modifier.width(12.dp))
                Box(
                    modifier = modifier
                        .weight(0.6f)
                        .height(30.dp)
                        .shimmerEffect()
                )
            }
        }
    } else {
        contentAfterLoading()
    }
}

fun Modifier.shimmerEffect(): Modifier = composed {
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    val transition = rememberInfiniteTransition()
    val startOfIndex by transition.animateFloat(
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(1000)
        )
    )
    background(
        brush = Brush.linearGradient(
            colors = listOf(
                Color(0xFFF1F1F1),
                Color(0xFFB4B4B4),
                Color(0xFFF1F1F1)
            ),
            start = Offset(startOfIndex, 0f),
            end = Offset(startOfIndex + size.width.toFloat(), size.height.toFloat())
        )
    )
        .onGloballyPositioned {
            size = it.size
        }
}