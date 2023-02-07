package net.denis.weatherapp.features.fetch_new_city.screen

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel

@Composable
fun FetchCityScreen(
    modifier: Modifier = Modifier,
    vm : FetchCityViewModel,
) {
    val state = vm.viewState.collectAsState()
    val cityState = state.value.cityName



}