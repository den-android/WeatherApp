package net.denis.weatherapp.features.detail_forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.features.current_forecast.model.HourlyItem
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailStore: DetailStore,
) : ViewModel() {
    val viewState: StateFlow<DetailState> = detailStore.state

    fun getHourlyItem(hourlyItem: HourlyItem) {
        viewModelScope.launch {
            detailStore.dispatch(DetailAction.GetHourlyItem(hourlyItem = hourlyItem))
        }
    }

}