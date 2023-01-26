package net.denis.weatherapp.features.forecast.screen

import android.icu.text.SimpleDateFormat
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.forecast.model.MeteorologyItem
import net.denis.weatherapp.features.forecast.model.MultipleView
import net.denis.weatherapp.features.forecast.mvi.ForecastViewModel
import net.denis.weatherapp.features.forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.forecast.screen.components.CurrentWeatherInfoDisplay
import net.denis.weatherapp.features.forecast.screen.components.WeatherForecastDisplay
import java.util.*

@Composable
fun CityCurrentWeatherScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    weather: MultipleView<MeteorologyItem>,
) {
//    weather?.let { itemWeather ->
//        Column(
//            modifier = modifier
//                .fillMaxSize()
//                .background(color = CityBackground)
//        ) {
//            Box(
//                modifier = modifier.weight(3f)
//            ) {
//                val formattedTime = remember(itemWeather.forecast.get(0).dt) {
//                    val sdf = SimpleDateFormat("HH:mm")
//                    val netDate = Date(itemWeather.forecast.get(0).dt.toLong() * 1000)
//                    sdf.format(netDate)
//                }
//                CurrentWeatherInfoDisplay(
//                    city = itemWeather.city.name,
//                    temp = itemWeather.forecast.get(0).main.temp,
//                    weatherDesc = itemWeather.forecast.get(0).meteorology.get(0).description,
//                    currentDateTime = formattedTime,
//                    weatherIcon = itemWeather.forecast.get(0).meteorology.get(0).id
//                )
//            }
//            Box(
//                modifier = modifier.weight(1f),
//            ) {
//                WeatherForecastDisplay(
//                    meteorologyItem = itemWeather,
//                    onClick = {
//                        navController.navigate(
//                            route = Screen.DetailForecastScreen.passDetailCnt(
//                                cnt = it
//                            )
//                        )
//                    }
//                )
//            }
//
//            BottomNavigateMenu(
//                onFabClicked = {
//                    navController.navigate(
//                        route = Screen.SearchCityScreen.passQuerry(
//                            city = it
//                        )
//                    )
//                }
//            )
//        }
//    }

}