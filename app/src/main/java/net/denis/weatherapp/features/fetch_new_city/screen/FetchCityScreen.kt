package net.denis.weatherapp.features.fetch_new_city.screen

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.core.presentation.ui.theme.MiddleGradientColor
import net.denis.weatherapp.core.presentation.ui.theme.PrimaryText
import net.denis.weatherapp.core.presentation.ui.theme.ViewBackground
import net.denis.weatherapp.core.util.Constants
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FetchCityScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: FetchCityViewModel,
) {
    val state = vm.viewState.collectAsState()
    val cityState = state.value.cityName

    var text by rememberSaveable { mutableStateOf("") }
    val con = LocalContext.current
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(CityBackground)
    ) {
        item {
            TopAppBar(
                modifier = modifier.background(ViewBackground),
                title = {
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                            if (it.length >= 3) {
                                vm.fetchCity(it)
                            }
                        },
                    )
                }
            )
        }

        cityState?.let {
            item {
                Card(
                    shape = RoundedCornerShape(10.dp),
                    border = BorderStroke(2.dp, MiddleGradientColor),
                    modifier = modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .background(ViewBackground),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = it.name,
                            color = PrimaryText,
                            fontSize = 32.sp,
                            textAlign = TextAlign.Center,
                            modifier = modifier
                                .clickable {
                                    Toast.makeText(con, "${it.lat}\n${it.lon}", Toast.LENGTH_SHORT).show()
                                    navController.currentBackStackEntry?.savedStateHandle?.set(
                                        key = Constants.PARAM_TO_MAIN_SCREEN,
                                        value = it
                                    )
                                    navController.navigate(
                                        route = Screen.MainForecastScreen.route
                                    )
                                }
                        )
                    }

                }

            }
        }
    }

}