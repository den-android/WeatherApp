package net.denis.weatherapp.features.main_forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainStore: MainStore,
) : ViewModel() {

    val viewState: StateFlow<MainState> = mainStore.state

    fun loadCurrentForecast() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.ForecastLoading)
        }
    }

    fun fetchForecastByCityName(lat: Double, lon: Double) {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.FetchForecastByCity(lat = lat, lon = lon))
        }
    }
}
