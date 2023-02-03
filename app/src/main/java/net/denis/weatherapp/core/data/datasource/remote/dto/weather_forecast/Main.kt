package net.denis.weatherapp.core.data.datasource.remote.dto.weather_forecast

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import java.util.*

data class Main(
    val feels_like: Double,
    val grnd_level: Int,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int,
    val temp: Double,
    val temp_kf: Double,
    val temp_max: Double,
    val temp_min: Double
) {
    fun toTemp(): String {
        return "${roundTemp(temp)}°"
    }
}

private fun roundTemp(temp: Double): String {
    val df = DecimalFormat("#.#", DecimalFormatSymbols(Locale.ENGLISH))
    return df.format(temp.toBigDecimal())
}