package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor

@Composable
fun BottomNavigateMenu(
    modifier: Modifier = Modifier,
    onFabClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .background(MiddleGradientColor),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        FloatingActionButton(onClick = { onFabClick() }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}