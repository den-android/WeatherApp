package net.denis.weatherapp.features.detail_forecast.screen

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import net.denis.weatherapp.R
import net.denis.weatherapp.core.presentation.ui.components.ErrorAlertDialog
import net.denis.weatherapp.core.presentation.ui.components.Toolbar
import net.denis.weatherapp.core.presentation.ui.theme.backgroundColor
import net.denis.weatherapp.features.detail_forecast.model.DualCard
import net.denis.weatherapp.features.detail_forecast.model.SingleCard
import net.denis.weatherapp.features.detail_forecast.mvi.DetailViewModel
import net.denis.weatherapp.features.detail_forecast.screen.components.card_type.DualCardUi
import net.denis.weatherapp.features.detail_forecast.screen.components.card_type.SingleCardUi
import kotlin.system.exitProcess

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    vm: DetailViewModel,
    onActionErrorClicked: () -> Unit,
) {
    val context = LocalContext.current
    val detailState by vm.viewState.collectAsState()

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(backgroundColor()))
            .paint(
                painter = painterResource(id = R.drawable.unsplash1),
                contentScale = ContentScale.FillWidth
            ),
    ) {
        item {
            detailState?.hourlyItem?.let {
                Toolbar(
                    label = it.detailData.cityDetail.cityName,
                    temp = it.temp
                )
            }
        }
        detailState.hourlyItem?.detailData?.detailList?.let { listWeather ->
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
