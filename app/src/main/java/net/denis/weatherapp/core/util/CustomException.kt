package net.denis.weatherapp.core.util

sealed class CustomException {
    data class NetworkException(val message: String) : CustomException()
}
