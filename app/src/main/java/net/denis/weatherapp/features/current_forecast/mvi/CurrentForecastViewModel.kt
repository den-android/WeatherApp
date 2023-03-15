package net.denis.weatherapp.features.current_forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import javax.inject.Inject

@HiltViewModel
class CurrentForecastViewModel @Inject constructor(
    private val currentForecastStore: CurrentForecastStore
) : ViewModel() {

    val viewState: StateFlow<CurrentForecastState> = currentForecastStore.state

    init {
        initCurrentScreen()
    }

    private fun initCurrentScreen() {
        viewModelScope.launch {
            currentForecastStore.dispatch(CurrentForecastAction.FetchForecast)
        }
    }

    fun onActionErrorClicked() {
        viewModelScope.launch {
            currentForecastStore.dispatch(CurrentForecastAction.OnActionErrorClicked)
        }
    }

    fun navigateTo(destination: INavigationCommand, params: Any?) {
        viewModelScope.launch {
            currentForecastStore.dispatch(CurrentForecastAction.NavigateTo(destination = destination, params = params))
        }
    }

}