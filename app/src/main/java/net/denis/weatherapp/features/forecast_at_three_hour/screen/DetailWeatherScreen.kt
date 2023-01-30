package net.denis.weatherapp.features.forecast_at_three_hour.screen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.features.forecast.model.*
import net.denis.weatherapp.features.forecast.screen.components.Toolbar
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithIndicator
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithText
import java.util.*

@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    detail: List<MultipleView<Detail>>,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground)
    ) {
        items(detail) { item ->
            when (item) {
                is MultipleView.WideCardWithText -> {
                    WindDetail(
                        title = item.title,
                        text = item.text,
                        indicatorValue = item.indicatorValue,
                        description = item.description
                    )
                }

                is MultipleView.CardWithText -> {
                    CloudyDetail(
                        title = item.title,
                        text = item.text,
                        description = item.description,
                    )
                }
                is MultipleView.CardWithIndicator -> {
                    VisibilityDetail(
                        title = item.title,
                        text = item.text,
                        visibility = item.indicatorValue,
                        description = item.description
                    )
                }

                is MultipleView.CardWithText -> {
                    SunriseDetail(
                        text = item.text
                    )
                }
                is MultipleView.CardWithText -> {
                    SunriseDetail(
                        text = item.text
                    )
                }
                else -> {}
            }
        }
    }

}

//    weather?.let { weatherItem ->
//        weatherItem?.forecast?.let { forecastList ->
//            LazyColumn(
//                modifier = modifier
//                    .fillMaxSize()
//                    .background(CityBackground),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween,
//            ) {
//                items(forecastList) { forecastItem ->
//                    if (forecastItem.dt == currentCnt) {
//
//                    }
//                }
//            }
//        }
//    }
//


@Composable
fun WindDetail(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    indicatorValue: Float,
    description: String,
) {
    CellWithIndicator(
        title = title,
        text = text,
        indicatorValue = indicatorValue,
        description = description
    )
}

@Composable
fun CloudyDetail(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    description: String
) {
    CellWithText(
        title = title,
        text = text,
        description = description,
    )
}

@Composable
fun VisibilityDetail(
    modifier: Modifier = Modifier,
    title: String,
    text: String,
    description: String,
    visibility: Float,
) {
    CellWithIndicator(
        title = title,
        text = text,
        description = description,
        indicatorValue = visibility,
    )
}

@Composable
fun SunriseDetail(
    modifier: Modifier = Modifier,
    text: String,
) {

    CellWithText(
        title = "Рассвет",
        text = "$text AM"
    )
}

@Composable
fun SunsetDetail(
    modifier: Modifier = Modifier,
    text: String,
) {
    CellWithText(
        text = "$text PM"
    )
}

//
//@Composable
//private fun DetailItems(
//    modifier: Modifier = Modifier,
//    weatherDto: WeatherDto,
//    currentCnt: Int,
//) {
//    weatherDto.list.forEach {
//
//    }
//
//    weatherDto?.list?.let { listItem ->
//        if (currentCnt == weatherDto.list[0].dt)
//        LazyColumn(
//            modifier = modifier
//                .fillMaxWidth()
//                .background(CityBackground)
//        ) {
//            items(listItem) { listItems->
//                DetailWindItem(
//                    modifier = modifier.fillMaxWidth(),
//                    wind = listItems.wind
//                )
//                DetailCloudyItem(
//                    cloudy = listItems.clouds
//                )
//            }
//        }
//    }
//}
//
//@Composable
//fun DetailWindItem(
//    modifier: Modifier = Modifier,
//    wind: Wind,
//) {
//    CellWithIndicator(
//        modifier = modifier,
//        title = "Ветер",
//        text = "${wind.speed}м/с",
//        indicatorValue = wind.speed.toFloat() / 10f,
//        description = "интенсивность ветра"
//    )
//}
//
//@Composable
//fun DetailCloudyItem(
//    modifier: Modifier = Modifier,
//    cloudy: Clouds,
//) {
//    Column(
//        modifier = modifier
//            .fillMaxSize()
//            .background(CityBackground),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Top,
//    ) {
//        Row(
//            modifier = modifier
//                .fillMaxWidth()
//        ) {
//            CellWithText(
//                title = "Облачность",
//                text = "${cloudy.all}%"
//            )
//        }
//    }
//}
//                    LazyRow(
//                        modifier = modifier
//                            .fillMaxWidth()
//                            .weight(0.4f),
//                    ) {
//                        items(weatherDtoItem.list) { forecastItem ->
//                            CellWithText(
//                                title = "Облачность",
//                                text = "${forecastItem.clouds.all}%\nза последние 3 часа"
//                            )
//
//                        }
//                    }


//
//
//@Composable
//private fun DetailItems2(
//    modifier: Modifier = Modifier,
//    weatherDto: WeatherDto,
//    currentCnt: Int,
//) {
//    for (i in 0..weatherDto.cnt - 1) {
//        if (currentCnt == weatherDto.list[i].dt) {
//            val formattedSunrise = remember(String) {
//                val sdf = SimpleDateFormat("HH:mm")
//                val netDate = Date(weatherDto.city.sunrise.plus(10800).toLong() * 1000)
//                sdf.format(netDate)
//            }
//            val formattedSunset = remember(String) {
//                val sdf = SimpleDateFormat("HH:mm")
//                val netDate = Date(weatherDto.city.sunset.plus(10800).toLong() * 1000)
//                sdf.format(netDate)
//            }
//            Column(
//                modifier = modifier
//                    .fillMaxSize()
//                    .background(CityBackground),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Top,
//            ) {
//
//                // Start Top item
//                CellWithIndicator(
//                    modifier = modifier
//                        .weight(0.2f)
//                        .fillMaxWidth(),
//                    title = "Ветер",
//                    indicatorValue = weatherDto.list[i].wind.speed.toFloat() / 10f
//                )
//                // End Top item
//
//                // Start middle item
//                Row(
//                    modifier = modifier
//                        .fillMaxWidth()
//                        .padding(32.dp)
//                        .weight(0.4f)
//                ) {
//                    CellWithText(
//                        title = "Рассвет",
//                        text = formattedSunrise,
//                        modifier = modifier
//                            .weight(0.5f)
//                    )
//                    Spacer(modifier = modifier.padding(4.dp))
//                    CellWithText(
//                        title = "Закат",
//                        text = formattedSunset,
//                        modifier = modifier
//                            .weight(0.5f)
//                    )
//                }
//                // End middle item
//
//                // Start bottom item
//                Row(
//                    modifier = modifier
//                        .fillMaxWidth()
//                        .padding(32.dp)
//                        .weight(0.4f)
//
//                ) {
//                    CellWithText(
//                        title = "Облачность",
//                        text = "${weatherDto.list[i].clouds.all}%\nза последние 3 часа",
//                        description = "${weatherDto.list[i].weather[0].description}",
//                        modifier = modifier
//                            .weight(0.5f)
//                    )
//                    Spacer(modifier = modifier.padding(4.dp))
//                    CellWithIndicator(
//                        title = "Видимость",
//                        indicatorValue = weatherDto.list[i].visibility / 10000f,
//                        modifier = modifier
//                            .weight(0.5f)
//                    )
//                }
//                // End bottom item
//            }
//        }
//    }
//}

/** latest
 *     val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

 * //        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(CityBackground)
//        ) {
//            Toolbar(
//                modifier = modifier.background(MiddleGradientColor),
//                label = weather.city.name,
//                onClicked = {
//                    onBackPressedDispatcher?.onBackPressed()
//                }
//            )
//            LazyColumn(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween,
//            ) {
//                items(itemList) { weatherData ->
//                    WindDetail(wind = weather.list[0].wind)
//                }
//            }
//            LazyColumn(
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceBetween,
//            ) {
//                items(itemList[currentId].wind) {
//                    WindDetail(wind = itemList[0].wind)
//                }
//                item {
//                    LazyRow {
//                        item {
//                            SunriseDetail(city = weather.city)
//                        }
//                        item {
//                            SunsetDetail(city = weather.city)
//                        }
//                    }
//                }
//
//        }
 */