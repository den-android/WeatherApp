package net.denis.weatherapp.features.forecast.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun CityCurrentWeatherScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
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