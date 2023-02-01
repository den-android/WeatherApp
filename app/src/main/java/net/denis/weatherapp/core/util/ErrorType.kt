package net.denis.weatherapp.core.util

sealed class ErrorType(val message: String) {
    object NetworkError: ErrorType("Check your internet connection")
    data class SomeError(val msg: String): ErrorType(message = msg)
}
