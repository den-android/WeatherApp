package net.denis.weatherapp.features.forecast.model

import androidx.compose.runtime.Composable
import net.denis.weatherapp.core.util.WeatherType
import net.denis.weatherapp.features.forecast.screen.CloudyDetail
import net.denis.weatherapp.features.forecast.screen.VisibilityDetail
import net.denis.weatherapp.features.forecast.screen.WindDetail

sealed class MultipleView {
    object WindItem : MultipleView()
    object CloudItem : MultipleView()
    object VisibilityItem : MultipleView()
    object EmptyItem: MultipleView()
}

//    object CurrentItem: MultipleView()
//    data class CityItem(val city: City) : MultipleView()
//    data class CloudItem(val cloud: Clouds) : MultipleView()
//    data class MainItem(val main: Main) : MultipleView()
//    data class MeteorologyItem(val meteorology: Meteorology) : MultipleView()
//    data class ListMeteorologyItem(val meteorologyItem: MeteorologyItem) : MultipleView()
//    data class WindItem(val wind: Wind) : MultipleView()
//    data class ForecastItem(val forecast: Forecast) : MultipleView()

//    data class CityItem(val city: City) : MultipleView()
//    data class CloudItem(val cloud: Clouds) : MultipleView()
//    data class MainItem(val main: Main) : MultipleView()
//    data class WeatherItem(val weather: Weather) : MultipleView()
//    data class WeatherItemItem(val weatherItemItem: WeatherItem) : MultipleView()
//    data class WindItem(val wind: Wind) : MultipleView()
//    data class ForecastItem(val forecast: Forecast) : MultipleView()

//    object CityItem : MultipleView()
//    object CloudItem : MultipleView()
//    object MainItem : MultipleView()
//    object WeatherItemItem : MultipleView()
//    object WindItem : MultipleView()
//    object ForecastItem : MultipleView()


