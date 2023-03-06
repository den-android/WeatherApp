package net.denis.weatherapp.core.util

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

sealed interface ErrorType

sealed class FailureResponse(
    val errMessage: String,
    val btnTitle: String,
    val alertState: Boolean = true,
) : ErrorType

sealed class OnHttpError : ErrorType {
    object Code1 : FailureResponse("Code1", "Code1", true)
    object Code2 : FailureResponse("Code2", "Code2",true)
    object Code401 : FailureResponse("Code401", "Code401", true)
}

sealed class OnExceptionError : ErrorType {
    //data class ExceptionError(val exception: Exception) :
    //   FailureResponse("${exception.localizedMessage}", "restart")
    // object ExHttpException : FailureResponse("ExHttpException", "ExHttpException")
    object ExUnknownHostException : FailureResponse("ExUnknownHostException", "restart", true)
    //object ExSocketTimeoutException : FailureResponse("ExSocketTimeoutException", "restart")
}