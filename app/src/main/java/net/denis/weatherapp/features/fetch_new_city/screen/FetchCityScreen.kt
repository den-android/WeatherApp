package net.denis.weatherapp.features.fetch_new_city.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import net.denis.weatherapp.R
import net.denis.weatherapp.core.presentation.navigation.directions.CurrentForecastDirections
import net.denis.weatherapp.core.presentation.ui.components.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.components.Toolbar
import net.denis.weatherapp.core.presentation.ui.theme.backgroundColor
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.fetch_new_city.screen.components.ResponseTextBox
import net.denis.weatherapp.features.fetch_new_city.screen.components.SearchCityTextField
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchCityScreen(
    modifier: Modifier = Modifier,
    vm: FetchCityViewModel,
) {
    val state by vm.viewState.collectAsState()

    state?.let {
        it.failureResponse?.let { failureResponse ->
            ErrorAlertDialog(
                onActionErrorClick = { vm.onActionErrorClicked() },
                onExitClick = { exitProcess(-1) },
                failureResponse = failureResponse
            )
        }
    }

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(backgroundColor()))
            .paint(
                painter = painterResource(id = R.drawable.unsplash1),
                contentScale = ContentScale.FillWidth
            )
    ) {
        item {
            Toolbar()
        }
        item {
            SearchCityTextField(searchCity = {
                vm.fetchCity(it)
            })
        }
        state.cityData?.let { cityData ->
            item {
                ResponseTextBox(
                    cityData = cityData,
                    onItemClick = {
                        vm.navigateTo(CurrentForecastDirections.CurrentForecast, cityData)
                    }
                )
            }
        }
    }
}