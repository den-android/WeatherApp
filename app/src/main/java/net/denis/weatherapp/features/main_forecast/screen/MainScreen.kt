package net.denis.weatherapp.features.main_forecast.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.error.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.error.ErrorType
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay
import kotlin.system.exitProcess

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    vm: MainViewModel,
    onRangeTimeClick: (Int, ForecastData) -> Unit,
    onFabClick: () -> Unit,
    onDismissClicked: () -> Unit,
) {
    val mainState by vm.viewState.collectAsState()

    val alertDialogState = remember { mutableStateOf(false) }

    mainState.error?.let {
        ErrorAlertDialog(
            onDismiss = {
                Log.d("Logging", "SCREEN 1${mainState.error}")
                onDismissClicked()
                Log.d("Logging", "SCREEN 2${mainState.error}")
            },
            onExit = { exitProcess(-1) },
            failureResponse = it
        )
    }

    mainState?.let { state ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = CityBackground)
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier.height(160.dp))
            }
            state.forecastData?.forecastList?.let { itemForecast ->
                Box(modifier = modifier.weight(3f)) {
                    CurrentWeatherDisplay(
                        city = state.forecastData.cityDetail.cityName,
                        weatherIcon = itemForecast[0].meteorology[0].id,
                        temp = itemForecast[0].temp,
                        weatherDesc = itemForecast[0].meteorology[0].description,
                        currentDateTime = itemForecast[0].dateTime
                    )
                }

                Box(modifier = modifier.weight(1f)) {
                    WeatherForecastDisplay(
                        forecastData = state.forecastData,
                        onClick = {
                            onRangeTimeClick(it, state.forecastData)
                        }
                    )
                }
            }
            BottomNavigateMenu(onFabClicked = { onFabClick() })
        }
    }
}
