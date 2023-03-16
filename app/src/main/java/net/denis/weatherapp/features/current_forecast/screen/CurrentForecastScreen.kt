package net.denis.weatherapp.features.current_forecast.screen

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
import net.denis.weatherapp.core.presentation.navigation.directions.DetailForecastDirections
import net.denis.weatherapp.core.presentation.navigation.directions.FetchCityDirections
import net.denis.weatherapp.core.presentation.ui.components.CustomCircularProgressIndicator
import net.denis.weatherapp.core.presentation.ui.components.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.theme.backgroundColor
import net.denis.weatherapp.features.current_forecast.mvi.CurrentForecastViewModel
import net.denis.weatherapp.features.current_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.current_forecast.screen.components.WeatherForecastDisplay
import net.denis.weatherapp.features.detail_forecast.screen.components.BottomNavigateMenu
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    vm: CurrentForecastViewModel
) {
    val state by vm.viewState.collectAsState()

    state.failureResponse?.let {
        ErrorAlertDialog(
            onActionErrorClick = { vm.onActionErrorClicked() },
            onExitClick = { exitProcess(-1) },
            failureResponse = it,
        )
    }

    Scaffold(
        bottomBar = {
            BottomNavigateMenu(onFabClick = {
                vm.navigateTo(FetchCityDirections.FetchNewCity)
            })
        }
    ) { padding ->
        Box(modifier = modifier.padding(padding)) {
            state?.let { state ->
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
                                currentDateTime = itemForecast.dateTime
                            )
                        }

                        Box(modifier = modifier.weight(1f)) {
                            WeatherForecastDisplay(
                                hourlyList = state.forecastData.hourlyList,
                                onClick = { hourlyItem ->
                                    vm.navigateTo(
                                        destination = DetailForecastDirections.DetailForecast,
                                        params = hourlyItem.detailData
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }

}
