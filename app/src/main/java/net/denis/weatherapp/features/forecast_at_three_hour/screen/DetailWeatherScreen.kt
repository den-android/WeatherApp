package net.denis.weatherapp.features.forecast_at_three_hour.screen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.util.MultipleView
import net.denis.weatherapp.features.forecast.screen.components.Toolbar
import net.denis.weatherapp.features.forecast_at_three_hour.mvi.DetailViewModel
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithIndicator
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithText
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.WideCellWithIndicator

@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val state = vm.viewState.collectAsState()
    val finallyDetailItem = state.value.detailData

    finallyDetailItem?.let { listWeather ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(CityBackground)
        ) {
            item {
                Toolbar(
                    modifier = modifier.background(MiddleGradientColor),
                    label = listWeather.cityName,
                    onClicked = {
                        onBackPressedDispatcher?.onBackPressed()
                    })
            }
            items(listWeather.tempDetail.toMultipleView()) { item ->
                when (item) {
                    is MultipleView.WideCardWithText -> {
                        WideCellWithIndicator(
                            title = item.title,
                            text = item.text,
                            description = item.description,
                            indicatorValue = item.indicatorValue,
                        )
                    }
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
                }
            }
        }

    }
}