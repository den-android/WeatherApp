package net.denis.weatherapp.features.fetch_new_city.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import javax.inject.Inject

@HiltViewModel
class FetchCityViewModel @Inject constructor(
    private val fetchCityStore: FetchCityStore
) : ViewModel() {
    val viewState: StateFlow<FetchCityState> = fetchCityStore.state

    fun fetchCity(name: String) {
        viewModelScope.launch {
            fetchCityStore.dispatch(FetchCityAction.FetchCity(name))
        }
    }

    fun onActionErrorClicked() {
        viewModelScope.launch {
            fetchCityStore.dispatch(FetchCityAction.OnActionErrorClicked)
        }
    }

    fun <P> navigateTo(destination: INavigationCommand, params: P? = null) {
        viewModelScope.launch {
            fetchCityStore.dispatch(FetchCityAction.NavigateTo(destination, params))
        }
    }

}