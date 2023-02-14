package net.denis.weatherapp.core.util

import retrofit2.HttpException
import retrofit2.Response

sealed class NetworkResult<T: Any> {
    class Success<T : Any>(val data: T) : NetworkResult<T>()
    class Error<T : Any>(val errorMessage: String?) : NetworkResult<T>()
}

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Error(errorMessage = response.message())
        }
    } catch (e: HttpException) {
        NetworkResult.Error(errorMessage = e.message())
    }
}