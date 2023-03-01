package net.denis.weatherapp.features.main_forecast.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import net.denis.weatherapp.R
import net.denis.weatherapp.core.presentation.ui.components.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.components.CustomCircularProgressIndicator
import net.denis.weatherapp.core.presentation.ui.theme.backgroundColor
import net.denis.weatherapp.features.detail_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.HourlyItem
import net.denis.weatherapp.features.main_forecast.model.HourlyModelCard
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    vm: MainViewModel,
    onRangeTimeClicked: (Int, HourlyModelCard) -> Unit,
    onFabClicked: () -> Unit,
) {
    val mainState by vm.viewState.collectAsState()

    mainState.error?.let {
        ErrorAlertDialog(
            onActionErrorClick = {
                vm.clearErrorState()
                vm.loadDefaultCity()
            },
            onExitClick = { exitProcess(-1) },
            failureResponse = it
        )
    }

    Scaffold(
        bottomBar = {
            BottomNavigateMenu(onFabClick = { onFabClicked() })
        }
    ) { padding ->
        Box(modifier = modifier.padding(padding)) {
            mainState?.let { state ->
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .background(brush = Brush.verticalGradient(backgroundColor()))
                        .paint(
                            painter = painterResource(id = R.drawable.unsplash1),
                            contentScale = ContentScale.FillWidth
                        )
                ) {
                    if (state.isLoading) {
                        CustomCircularProgressIndicator()
                    }
                    state.forecastData?.forecast?.let { itemForecast ->

                        Box(modifier = modifier.weight(3f)) {
                            CurrentWeatherDisplay(
                                city = state.forecastData.cityDetail.cityName,
                                weatherIcon = itemForecast.meteorology[0].id,
                                temp = itemForecast.temp,
                                weatherDesc = itemForecast.meteorology[0].description,
                                currentDateTime = itemForecast.dateTime.toString()
                            )
                        }

                        Box(modifier = modifier.weight(1f)) {
                            WeatherForecastDisplay(
                                hourlyList = state.forecastData.hourlyList,
                                onClick = {
                                    onRangeTimeClicked(it, state.forecastData.hourlyList[1])
                                }
                            )
                        }
                    }
                }
            }
        }
    }

}
