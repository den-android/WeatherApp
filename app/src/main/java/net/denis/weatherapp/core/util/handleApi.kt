package net.denis.weatherapp.core.util

import retrofit2.Response

suspend fun <T : Any> handleApi(
    execute: suspend () -> Response<T>
): NetworkResult<T> {
    return try {
        val response = execute()
        val body = response.body()
        if (response.isSuccessful && body != null) {
            NetworkResult.Success(body)
        } else {
            NetworkResult.Failure(code = response.code(), message = response.message())
        }
    } catch (e: Exception) {
        NetworkResult.Exception(e)
    }
}