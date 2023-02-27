package net.denis.weatherapp.features.detail_forecast.screen

import android.widget.Toast
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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import net.denis.weatherapp.core.presentation.error.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.features.detail_forecast.model.DualCard
import net.denis.weatherapp.features.detail_forecast.model.SingleCard
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.DualCardUi
import net.denis.weatherapp.features.detail_forecast.screen.components.SingleCardUi
import net.denis.weatherapp.features.detail_forecast.screen.components.Toolbar
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel,
    onActionErrorClicked: () -> Unit,
) {
    val context = LocalContext.current

    val detailState by vm.viewState.collectAsState()

    detailState.error?.let {
        ErrorAlertDialog(
            onActionErrorClick = {
                vm.clearErrorState()
                onActionErrorClicked()
            },
            onExitClick = { exitProcess(-1) },
            failureResponse = it
        )
    }

    Scaffold(
        topBar = {
            detailState.detailData?.let { detailData ->
                Toolbar(
                    label = detailData.cityDetail.cityName,
                    modifier = modifier.background(MiddleGradientColor),
                )
            }
        },
    ) { contentPadding ->
        Box(modifier = modifier.padding(contentPadding)) {
            detailState.detailData?.detailList?.let { listWeather ->
                LazyColumn(
                    modifier = modifier
                        .fillMaxSize()
                        .background(CityBackground),
                ) {
                    items(listWeather) { item ->
                        when (item) {

                            is SingleCard.WideCardWithText -> {
                                SingleCardUi(
                                    cellFields = item.cellFields,
                                    onCellClicked = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }

//                            is DualCard.Custom -> {
//                                DualCardUi(
//                                    leftCard = item.cardOne,
//                                    rightCard = item.cardTwo,
//                                    onCellClicked = {
//                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
//                                    }
//                                )
//                            }
//
//                            is DetailModelCard.DualCard.Custom -> {
//                                RowCellTextAndIndicator(
//                                    cellFields = item.cardOne,
//                                    indicatorCellFields = item.cardWithIndicator.indicatorCellFields,
//                                    onCellClicked = {
//                                        Toast.makeText(context, it,Toast.LENGTH_SHORT).show()
//                                    }
//                                )
//                            }
//
//                            is DetailModelCard.CardWithIndicator -> {
//                                CellWithIndicator(
//                                    indicatorCellFields = item.indicatorCellFields,
//                                    onCellClicked = {
//                                        Toast.makeText( context, it, Toast.LENGTH_SHORT).show()
//                                    }
//                                )
//                            }

                            else -> {}
                        }
                    }
                }
            }
        }
    }
}