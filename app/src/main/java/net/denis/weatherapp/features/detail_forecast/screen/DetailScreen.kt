package net.denis.weatherapp.features.detail_forecast.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.platform.LocalContext
import net.denis.weatherapp.core.presentation.error.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.detail_forecast.model.DualCard
import net.denis.weatherapp.features.detail_forecast.model.SingleCard
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.card_type.DualCardUi
import net.denis.weatherapp.features.detail_forecast.screen.components.card_type.SingleCardUi
import kotlin.system.exitProcess

@OptIn(
    ExperimentalMaterial3Api::class,
    ExperimentalLayoutApi::class,
    ExperimentalComposeUiApi::class,
)
@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel,
    onActionErrorClicked: () -> Unit,
) {
    val context = LocalContext.current
    val detailState by vm.viewState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "${detailState.detailData?.cityDetail?.cityName}"
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
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
                                    card = item.card,
                                    onCellClicked = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                                    }
                                )
                            }

                            is DualCard.DualCardItem -> {
                                DualCardUi(
                                    leftCard = item.cardOne,
                                    rightCard = item.cardTwo,
                                    onCellClicked = {
                                        Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
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
}