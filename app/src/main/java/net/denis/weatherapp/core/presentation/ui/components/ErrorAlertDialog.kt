package net.denis.weatherapp.core.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import net.denis.weatherapp.core.util.FailureResponse

@Composable
fun ErrorAlertDialog(
    modifier: Modifier = Modifier,
    onActionErrorClick: () -> Unit,
    onExitClick: () -> Unit,
    failureResponse: FailureResponse
) {
    Dialog(
        onDismissRequest = { onActionErrorClick() },
        properties = DialogProperties(
            dismissOnBackPress = false, dismissOnClickOutside = false
        )
    ) {
        Card(
            shape = RoundedCornerShape(10.dp),
            modifier = modifier
                .fillMaxWidth()
                .padding(8.dp),
        ) {
            Column(
                Modifier
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = failureResponse.errMessage,
                    textAlign = TextAlign.Center,
                    modifier = modifier.padding(8.dp), fontSize = 20.sp
                )
                Row(Modifier.padding(top = 10.dp)) {
                    OutlinedButton(
                        onClick = { onExitClick() },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Text(text = "Закрыть")
                    }

                    Button(
                        onClick = { onActionErrorClick() },
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(8.dp)
                            .weight(1f)
                    ) {
                        Text(
                            overflow = TextOverflow.Ellipsis,
                            maxLines = 1,
                            text = failureResponse.btnTitle,
                        )
                    }
                }


            }
        }
    }
}