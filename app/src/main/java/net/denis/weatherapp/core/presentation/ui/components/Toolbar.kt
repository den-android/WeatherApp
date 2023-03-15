package net.denis.weatherapp.core.presentation.ui.components

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.R
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    label: String? = null,
    temp: String? = null,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    Box(
        modifier = modifier
            .padding(4.dp)
        ) {
        Row(
            modifier = modifier
                .height(54.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBackPressedDispatcher?.onBackPressed() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_angle_left),
                    contentDescription = null,
                    tint = Color.White
                )
            }
            Column(
                modifier = modifier
                    .fillMaxWidth(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = label?:"",
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp,
                    color = PrimaryText
                )
                Text(
                    text = temp?:"",
                    textAlign = TextAlign.Center,
                    fontSize = 14.sp,
                    color = PrimaryText
                )
            }

        }
    }
    Divider(color = Color.LightGray)
}