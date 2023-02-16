package net.denis.weatherapp.core.util

sealed interface ErrorHandler<T: Any>

sealed class NetworkResult<T : Any>: ErrorHandler<T> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Failure<T : Any>(val code: Int, val message: String) : NetworkResult<T>()
    class Exception<T : Any>(val e: kotlin.Exception) : NetworkResult<T>()
}

sealed class SomeResult<T: Any>: ErrorHandler<T> {
    class Success<T : Any>(val data: T) : SomeResult<T>()
    class Failure<T : Any>(val message: String) : SomeResult<T>()
    class Exception<T : Any>(val e: kotlin.Exception) : SomeResult<T>()
}