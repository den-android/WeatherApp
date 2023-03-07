package net.denis.weatherapp.core.presentation.navigation.test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.features.main_forecast.mvi.MainAction
import net.denis.weatherapp.features.main_forecast.mvi.MainState
import net.denis.weatherapp.features.main_forecast.mvi.MainStore
import javax.inject.Inject

@HiltViewModel
class TestCurrentVM @Inject constructor(
    private val mainStore: MainStore,
) : ViewModel() {

    val viewState: StateFlow<MainState> = mainStore.state

//    fun navigateToFetchCity() {
//        navigationManager.navigate(ForecastDirections.CurrentForecast)
//    }

    fun navigateToFetchCity() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.NavigateToFetchCity)
        }
    }
}