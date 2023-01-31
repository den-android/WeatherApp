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
import net.denis.weatherapp.features.forecast.model.*
import net.denis.weatherapp.features.forecast.screen.components.Toolbar
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.features.forecast_at_three_hour.mvi.DetailState
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithIndicator
import net.denis.weatherapp.features.forecast_at_three_hour.screen.components.compose_items.CellWithText
import java.util.*

@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    //detail: List<MultipleView<Detail>>,
    detailState: State<DetailState>,
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher

    detail?.let { detail ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .background(CityBackground)
        ) {
            item {
                Toolbar(
                    modifier = modifier.background(MiddleGradientColor),
                    //label = detail.city.name,
                    onClicked = {
                        onBackPressedDispatcher?.onBackPressed()
                    })
            }

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
}

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