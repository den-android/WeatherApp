package net.denis.weatherapp.features.fetch_new_city.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.ViewBackground
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchCityScreen(
    modifier: Modifier = Modifier,
    vm: FetchCityViewModel,
) {
    val state = vm.viewState.collectAsState()
    val cityState = state.value.cityName

    var text by rememberSaveable { mutableStateOf("") }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground)
    ) {
        item {
            TopAppBar(
                modifier = modifier.background(ViewBackground),
                title = {
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                    )
                }
            )
        }
        item {
            Button(onClick = {
                vm.fetchCity(name = "Екатеринбург")
            }) {
                Text("Search")
            }
        }
    }

}