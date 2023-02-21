package net.denis.weatherapp.core.util

import androidx.annotation.Keep

@Keep
data class FailureResponse(
    val errMessage: String,
    val btnTitle: String
)