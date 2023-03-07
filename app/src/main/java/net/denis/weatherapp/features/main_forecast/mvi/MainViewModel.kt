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
        fetchForecast()
    }

    private fun fetchForecast() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.FetchForecast)
        }
    }

    fun onActionErrorClicked() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.FixError)
        }
    }

}