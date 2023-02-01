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
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast.screen.components.Toolbar
import net.denis.weatherapp.features.forecast_at_three_hour.mvi.DetailViewModel
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithIndicator
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithText

@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val state = vm.viewState.collectAsState()
    val detailList = state.value.testDetailData


    detailList?.let { listWeather ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(CityBackground)
        ) {
            item {
                Toolbar(
                    modifier = modifier.background(MiddleGradientColor),
                    //label = it.cityDetail.name,
                    onClicked = {
                        onBackPressedDispatcher?.onBackPressed()
                    })
            }
            items(listWeather) { item ->
                when (item) {
                    is MultipleView.CardWithIndicator -> {
                        CellWithIndicator(
                            title = item.title,
                            text = item.text,
                            indicatorValue = item.indicatorValue
                        )
                    }
                    is MultipleView.CardWithText -> {
                        CellWithText(
                            title = item.title,
                            text = item.text
                        )
                    }
                    is MultipleView.WideCardWithText -> {

                    }
                }
            }
        }

    }
}

@Composable
private fun WindDetail(
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
private fun CloudyDetail(
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
private fun VisibilityDetail(
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
private fun SunriseDetail(
    modifier: Modifier = Modifier,
    text: String,
) {
    CellWithText(
        text = text
    )
}

@Composable
private fun SunsetDetail(
    modifier: Modifier = Modifier,
    text: String,
) {
    CellWithText(
        text = text
    )
}