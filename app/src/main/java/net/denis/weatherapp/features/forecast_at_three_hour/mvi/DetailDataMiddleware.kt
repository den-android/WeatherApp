package net.denis.weatherapp.features.forecast_at_three_hour.mvi

import android.util.Log
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.features.forecast_at_three_hour.model.Cloud
import net.denis.weatherapp.features.forecast_at_three_hour.model.Detail
import net.denis.weatherapp.features.forecast_at_three_hour.model.DetailData
import net.denis.weatherapp.features.forecast_at_three_hour.model.Wind

class DetailDataMiddleware(
    private val weatherRepository: IWeatherRepository,
) : Middleware<DetailState, DetailAction> {

    override suspend fun process(
        action: DetailAction,
        currentState: DetailState,
        store: Store<DetailState, DetailAction>
    ) {
        when (action) {
            is DetailAction.GetCurrentId -> {
                detailLoading(currentId = action.currentId, store = store)
            }

            else -> currentState
        }
    }

    private suspend fun detailLoading(currentId: Int, store: Store<DetailState, DetailAction>) {
        weatherRepository.getForecast(
            lat = 55.7504461,
            lon = 37.6174943,
            exclude = "alerts",
            apiKey = "b05865d24d90b1dbccfb3ced2627b4e9"
        )
            .collect { data ->
                val _mappedData: List<Detail> = listOf(data.detailData.detailList[currentId])

                Log.d("Logging", "----------- ${_mappedData}}")

                val mappedData: Detail = _mappedData[currentId]

                store.dispatch(DetailAction.DetailForecastLoaded(mappedData))

            }

    }

}


//    private suspend fun forecastLoadi2ng(currentId: Int, store: Store<DetailState, DetailAction>) {
//        weatherRepository.getForecast(lat = 55.7504461, lon = 37.6174943, exclude = "alerts", apiKey = "b05865d24d90b1dbccfb3ced2627b4e9")
//            .collect { data ->
//                val _mappedData: DetailItem? = null
//                _mappedData?.copy(
//                    wind = Wind(
//                        speed = data.forecast[currentId].wind.speed
//                    ),
//                    cloud = Clouds(
//                        all = 10
//                    ),
//                )
//
//                val mappedData: List<DetailItem?> = listOf(_mappedData)
//
//                store.dispatch(DetailAction.DetailForecastLoaded(detailItem = mappedData))
//            }
//
//    }
