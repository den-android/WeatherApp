package net.denis.weatherapp.features.detail_forecast.screen

import android.widget.Toast
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.util.DetailModelCard
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailWeatherScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel
) {
    val context = LocalContext.current

    val state = vm.viewState.collectAsState()
    val detailState = state.value.detailData
    Scaffold(
        topBar = {
            detailState?.let {
                Toolbar(
                    label = it.cityDetail.cityName,
                    modifier = modifier.background(MiddleGradientColor),
                )
            }
        },
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

                            is DetailModelCard.WideCardWithText -> {
                                WideCellWithIndicator(
                                    indicatorCellFields = item.indicatorCellFields,
                                    onCellClicked = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }

                            is DetailModelCard.CardWithTextAndText -> {
                                RowCellTextAndText(
                                    leftCellFields = item.leftCardWithText.cellFields,
                                    rightCellFields = item.rightCardWithText.cellFields,
                                    onCellClicked = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }

                            is DetailModelCard.CardWithTextAndIndicator -> {
                                RowCellTextAndIndicator(
                                    cellFields = item.cardWithText.cellFields,
                                    indicatorCellFields = item.cardWithIndicator.indicatorCellFields,
                                    onCellClicked = {
                                        Toast.makeText(context, it,Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }

                            is DetailModelCard.CardWithIndicator -> {
                                CellWithIndicator(
                                    indicatorCellFields = item.indicatorCellFields,
                                    onCellClicked = {
                                        Toast.makeText( context, it, Toast.LENGTH_SHORT).show()
                                    }
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