package net.denis.weatherapp.features.fetch_new_city.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.presentation.error.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.ViewBackground
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.components.ResponseTextBox
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchCityScreen(
    modifier: Modifier = Modifier,
    vm: FetchCityViewModel,
    navigateUp: (CityData) -> Unit,
    onActionErrorClicked: () -> Unit,
) {
    val cityState by vm.viewState.collectAsState()
    var textFieldValue by rememberSaveable { mutableStateOf("") }

    cityState.error?.let {
        ErrorAlertDialog(
            onActionErrorClick = {
                vm.clearErrorState()
                onActionErrorClicked()
            },
            onExitClick = { exitProcess(-1) },
            failureResponse = it
        )
    }

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
                        value = textFieldValue,
                        onValueChange = {
                            textFieldValue = it
                            if (it.length >= 3) {
                                vm.fetchCity(it)
                            }
                        },
                    )
                }
            )
        }
        cityState.cityData?.let { cityData ->
            item {
                ResponseTextBox(
                    cityData = cityData,
                    onItemClick = {
                        navigateUp(cityData)
                    }
                )
            }
        }
    }
}