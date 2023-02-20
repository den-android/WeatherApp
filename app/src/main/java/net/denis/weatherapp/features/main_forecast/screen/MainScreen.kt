package net.denis.weatherapp.features.main_forecast.screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import net.denis.weatherapp.core.presentation.navigation.Screen
import net.denis.weatherapp.core.presentation.ui.theme.CityBackground
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import net.denis.weatherapp.features.fetch_new_city.mvi.FetchCityViewModel
import net.denis.weatherapp.features.main_forecast.mvi.MainState
import net.denis.weatherapp.features.main_forecast.mvi.MainViewModel
import net.denis.weatherapp.features.main_forecast.screen.components.BottomNavigateMenu
import net.denis.weatherapp.features.main_forecast.screen.components.CurrentWeatherDisplay
import net.denis.weatherapp.features.main_forecast.screen.components.WeatherForecastDisplay

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    vm: MainViewModel,
    fetchCityVM: FetchCityViewModel,
) {

    val mainState by vm.viewState.collectAsState()
    val fetchCityState by fetchCityVM.viewState.collectAsState()

    fetchCityState.cityData?.let {
        Log.d("Logging", "Loading VM")
        vm.fetchForecast(it.lat, it.lon)
    }

    mainState?.let { state ->

    }

}
