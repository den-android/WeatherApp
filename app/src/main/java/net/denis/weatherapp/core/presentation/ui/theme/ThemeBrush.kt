package net.denis.weatherapp.core.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun backgroundColor(): List<Color> {
    return listOf(
        StartBackgroundColor,
        EndBackgroundColor,
        StartMiddleBackgroundColor,
        EndMiddleBackgroundColor
    )
}

@Composable
fun middleBackgroundBrush(): List<Color> {
    return listOf(
        StartMiddleBackgroundColor,
        EndMiddleBackgroundColor
    )
}