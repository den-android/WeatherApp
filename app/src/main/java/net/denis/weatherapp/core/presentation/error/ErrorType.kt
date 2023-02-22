package net.denis.weatherapp.core.presentation.error

import net.denis.weatherapp.core.presentation.error.model.HttpErrorResponse

sealed class ErrorType {
    data class HttpError(val httpErrorResponse: HttpErrorResponse): ErrorType()
    data class OnExceptionError(val exMessage: String): ErrorType()
}