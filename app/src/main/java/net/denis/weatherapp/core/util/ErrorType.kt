package net.denis.weatherapp.core.util

sealed class ErrorType(val message: String? = null) {
    object NetworkError: ErrorType("Check your internet connection")
    object invalid: ErrorType()
    data class SomeError(val msg: String): ErrorType(message = msg)
}
