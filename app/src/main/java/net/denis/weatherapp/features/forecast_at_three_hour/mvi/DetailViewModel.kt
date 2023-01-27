package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailStore: DetailStore,
): ViewModel() {
    val viewState: StateFlow<DetailState> = detailStore.state

    init {
        getCurrentId()
    }

    fun getCurrentId() {
        viewModelScope.launch {
            detailStore.dispatch(DetailAction.GetCurrentId(0))
        }
    }
}