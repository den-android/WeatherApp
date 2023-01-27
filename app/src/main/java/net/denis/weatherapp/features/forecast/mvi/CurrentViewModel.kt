package net.denis.weatherapp.features.forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CurrentViewModel @Inject constructor(
    private val forecastStore: ForecastStore,
) : ViewModel() {

    val viewState: StateFlow<ForecastState> = forecastStore.state

    init {
        loadCurrentForecast()
    }

    private fun loadCurrentForecast() {
        viewModelScope.launch {
            forecastStore.dispatch(ForecastAction.ForecastLoading)
        }
    }
}
