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

    init {
        loadDefaultCity()
    }

    fun loadDefaultCity() {
        fetchForecast(lat = 47.2213858, lon = 39.7114196)
    }

    fun fetchForecast(lat: Double, lon: Double) {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.FetchForecast(lat = lat, lon = lon))
        }
    }

    fun clearErrorState() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.ClearErrorState)
        }
    }
}