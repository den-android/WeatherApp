package net.denis.weatherapp.features.detail_forecast.screen

import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.util.ViewType
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.CellWithIndicator
import net.denis.weatherapp.features.detail_forecast.screen.components.RowCell
import net.denis.weatherapp.features.detail_forecast.screen.components.Toolbar
import net.denis.weatherapp.features.detail_forecast.screen.components.WideCellWithIndicator
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel
) {
    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val state = vm.viewState.collectAsState()
    val detailState = state.value.detailData
    Scaffold(
        topBar = {
            Toolbar(
                label = "msk",
                modifier = modifier.background(MiddleGradientColor),
                onClicked = { onBackPressedDispatcher?.onBackPressed() }
            )
        },
        bottomBar = {
            BottomNavigateMenu(onFabClicked = {})
        },

        floatingActionButton = { },
    ) { contentPadding ->
        Box(modifier = modifier.padding(contentPadding)) {
            detailState?.detailList?.let { listWeather ->
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .background(CityBackground),
                ) {
                    items(listWeather) { item ->
                        when (item) {
                            is ViewType.WideCardWithText -> {
                                WideCellWithIndicator(
                                    indicatorCellFields = item.indicatorCellFields
                                )
                            }
                            is ViewType.RowCardItem -> {
                                RowCell(
                                    cellFields = item.cardWithText.cellFields,
                                    indicatorCellFields = item.cardWithIndicator.indicatorCellFields,
                                    onCellClicked = { }
                                )
                            }

                            is ViewType.CardWithIndicator -> {
                                CellWithIndicator(
                                    indicatorCellFields = item.indicatorCellFields,
                                )
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
    }
}