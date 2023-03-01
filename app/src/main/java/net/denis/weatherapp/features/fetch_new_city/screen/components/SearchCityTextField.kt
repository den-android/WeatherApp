package net.denis.weatherapp.features.fetch_new_city.screen.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import net.denis.weatherapp.R
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchCityTextField(
    modifier: Modifier = Modifier,
    searchCity: (String) -> Unit,
) {
    var textFieldValue by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .height(60.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        TextField(modifier = modifier
            .fillMaxWidth(),
            value = textFieldValue,
            onValueChange = {
                textFieldValue = it

            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = PrimaryColor,
                textColor = PrimaryText
            ),
            label = {
                Row(
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_search),
                        contentDescription = null,
                        tint = Color.LightGray
                    )
                    Spacer(modifier = modifier.padding(start = 4.dp))
                    Text(text = "Search for city or airport")
                }

            }
        )
        LaunchedEffect(key1 = textFieldValue) {
            if (textFieldValue.length >= 3) {
                delay(300L)
                searchCity(textFieldValue)
            }
        }
    }

}