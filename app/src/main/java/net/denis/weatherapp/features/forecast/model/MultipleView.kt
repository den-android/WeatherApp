package net.denis.weatherapp.features.forecast.model

sealed interface CityForecastInfo
sealed interface DetailForecastInfo

sealed class MultipleView<T: Any> {

    data class ItemCity<T : Any>(val city: City) : MultipleView<T>()
    data class ItemCloud<T : Any>(val cloud: Clouds) : MultipleView<T>()
    data class ItemMain<T : Any>(val main: Main) : MultipleView<T>()
    data class ItemMeteorology<T : Any>(val meteorology: Meteorology) : MultipleView<T>()
    data class ItemListMeteorology<T : Any>(val meteorologyItem: MeteorologyItem) : MultipleView<T>()
    data class ItemWind<T : Any>(val wind: Wind) : MultipleView<T>()
    data class ItemForecast<T : Any>(val forecast: Forecast) : MultipleView<T>()

}