package net.denis.weatherapp.features.main_forecast.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.features.main_forecast.model.ForecastData
import net.denis.weatherapp.features.main_forecast.model.HourlyItem
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainStore: MainStore,
) : ViewModel() {

    val viewState: StateFlow<MainState> = mainStore.state

    init {
        //   loadDefaultCity()
        viewModelScope.launch {
        mainStore.dispatch(MainAction.FetchForecast)
    }
    }
//
//    fun loadDefaultCity() {
//        fetchForecast(lat = 47.2213858, lon = 39.7114196)
//    }
//
//    fun fetchForecast(lat: Double, lon: Double) {
//        viewModelScope.launch {
//            mainStore.dispatch(MainAction.FetchForecast(lat = lat, lon = lon))
//        }
//    }

//    fun navigateToDetail(hourlyItem: HourlyItem) {
//        viewModelScope.launch {
//            mainStore.dispatch(MainAction.NavigateToDetail(hourlyItem = hourlyItem))
//        }
//    }

    fun FixError() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.FixError)
        }
    }

    fun clearErrorState() {
        viewModelScope.launch {
            mainStore.dispatch(MainAction.ClearErrorState)
        }
    }

}