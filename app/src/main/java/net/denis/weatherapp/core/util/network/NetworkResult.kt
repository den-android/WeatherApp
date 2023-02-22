package net.denis.weatherapp.core.util.network

sealed class NetworkResult<T : Any> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Failure<T : Any>(val code: Int, val message: String) : NetworkResult<T>()
    class Exception<T : Any>(val e: kotlin.Exception) : NetworkResult<T>()
}