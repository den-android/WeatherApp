package net.denis.weatherapp.features.detail_forecast.mvi

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val detailStore: DetailStore,
) : ViewModel() {
    val viewState: StateFlow<DetailState> = detailStore.state

    fun getDetail(detailData: DetailData) {
        Log.d("Logging","VIEWMODEL ${detailData}")
        viewModelScope.launch {
            detailStore.dispatch(DetailAction.GetDetailData(detailData = detailData))
        }
    }
}