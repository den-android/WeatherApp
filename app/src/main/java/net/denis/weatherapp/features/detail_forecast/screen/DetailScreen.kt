package net.denis.weatherapp.features.detail_forecast.screen

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.util.ViewType
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.*
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel
) {
    val context = LocalContext.current

    val onBackPressedDispatcher = LocalOnBackPressedDispatcherOwner.current?.onBackPressedDispatcher
    val state = vm.viewState.collectAsState()
    val detailState = state.value.detailData
    Scaffold(
        topBar = {
            detailState?.let {
                Toolbar(
                    label = it.sunDetail.cityName,
                    modifier = modifier.background(MiddleGradientColor),
                    onClicked = { onBackPressedDispatcher?.onBackPressed() }
                )
            }
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
                                    indicatorCellFields = item.indicatorCellFields,
                                    onCellClicked = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
                                )
                            }

                            is ViewType.CardWithTextAndText -> {
                                RowCellTextAndText(
                                    leftCellFields = item.leftCardWithText.cellFields,
                                    rightCellFields = item.rightCardWithText.cellFields,
                                    onCellClicked = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
                                )
                            }

                            is ViewType.CardWithTextAndIndicator -> {
                                RowCellTextAndIndicator(
                                    cellFields = item.cardWithText.cellFields,
                                    indicatorCellFields = item.cardWithIndicator.indicatorCellFields,
                                    onCellClicked = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
                                )
                            }

                            is ViewType.CardWithIndicator -> {
                                CellWithIndicator(
                                    indicatorCellFields = item.indicatorCellFields,
                                    onCellClicked = { Toast.makeText(context, it, Toast.LENGTH_SHORT).show() }
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