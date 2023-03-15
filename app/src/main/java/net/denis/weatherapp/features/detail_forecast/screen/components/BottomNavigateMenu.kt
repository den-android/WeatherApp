package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigateMenu(
    modifier: Modifier = Modifier,
    onFabClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(bottom = 6.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        FloatingActionButton(onClick = { onFabClick() }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription = null)
        }
    }
}