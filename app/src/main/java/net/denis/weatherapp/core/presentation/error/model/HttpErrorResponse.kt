package net.denis.weatherapp.core.presentation.error.model

import androidx.annotation.Keep

@Keep
data class HttpErrorResponse(
    val code: Int,
    val message: String
)