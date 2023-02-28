package net.denis.weatherapp.features.detail_forecast.screen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.denis.weatherapp.core.presentation.ui.theme.CellBackgroundColor
import net.denis.weatherapp.core.presentation.ui.theme.CellBorderColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.features.detail_forecast.model.CellFields

@Composable
fun CellUi(
    modifier: Modifier = Modifier,
    cell: CellFields,
    onCellClick: (String) -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(15))
            .border(
                border = BorderStroke(width = 1.dp, color = CellBorderColor),
                shape = RoundedCornerShape(15)
            )
            .clickable { onCellClick(cell.title) }
    ) {
        Column(
            modifier = modifier
                .background(CellBackgroundColor)
                .padding(12.dp)
                .fillMaxSize()
                .fillMaxHeight(0.25f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = cell.icon ?: 0),
                    contentDescription = null,
                    tint = Color.White
                )
                Spacer(modifier = modifier.padding(start = 6.dp))
                cell.title?.let { title ->
                    Text(
                        text = title,
                        fontSize = 22.sp,
                        color = PrimaryText,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = modifier.height(2.dp))
                }
            }

            cell.text?.let { text ->
                Text(
                    text = text,
                    fontSize = 16.sp,
                    color = PrimaryText,
                    textAlign = TextAlign.Center,
                )
                Spacer(modifier = modifier.height(2.dp))
            }

            cell.indicatorValue?.let { value ->
                CustomLPB(indicatorValue = value)
                Spacer(modifier = modifier.height(2.dp))
            }

            cell.description?.let { description ->
                Text(
                    text = description,
                    fontSize = 14.sp,
                    color = PrimaryText,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}