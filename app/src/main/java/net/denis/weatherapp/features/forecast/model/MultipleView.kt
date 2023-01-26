package net.denis.weatherapp.features.forecast.model

sealed class MultipleView<T: Any> {

    data class itm2(val wqe: String): MultipleView()

    data class itm3(): MultipleView()

    data class itm1(): MultipleView()

}