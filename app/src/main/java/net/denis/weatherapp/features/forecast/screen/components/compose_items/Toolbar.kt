package net.denis.weatherapp.features.forecast.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    label: String = "Label",
    onClicked: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxWidth(),

        ) {
        Row(
            modifier = modifier
                .height(44.dp)
                .fillMaxWidth()
        ) {
            IconButton(onClick = { onClicked() }) {
                Image(imageVector = Icons.Filled.ArrowBack, contentDescription = null)
            }
            Text(
                text = label,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = PrimaryText
            )
        }
    }
}