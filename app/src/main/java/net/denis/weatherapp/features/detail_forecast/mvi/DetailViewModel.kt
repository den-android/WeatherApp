package net.denis.weatherapp.features.detail_forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.features.main_forecast.model.ForecastItem
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailStore: DetailStore,
) : ViewModel() {
    val viewState: StateFlow<DetailState> = detailStore.state

    fun getForecastItem(forecastItem: ForecastItem) {
        viewModelScope.launch {
            detailStore.dispatch(DetailAction.GetForecastItem(forecastItem = forecastItem))
        }
    }

    fun clearErrorState() {
        viewModelScope.launch {
            detailStore.dispatch(DetailAction.ClearErrorState)
        }
    }
}