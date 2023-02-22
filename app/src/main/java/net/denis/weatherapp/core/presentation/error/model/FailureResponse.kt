package net.denis.weatherapp.core.presentation.error.model

import androidx.annotation.Keep

@Keep
data class FailureResponse(
    val errMessage: String,
    val btnTitle: String
)