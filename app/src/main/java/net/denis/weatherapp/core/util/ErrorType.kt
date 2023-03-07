package net.denis.weatherapp.core.util

sealed interface ErrorType

sealed class FailureResponse(
    val errMessage: String,
    val btnTitle: String,
    val alertState: Boolean = true,
) : ErrorType

sealed class OnHttpError : ErrorType {
    object Code1 : FailureResponse("Code1", "Code1")
    object Code2 : FailureResponse("Code2", "Code2")
    object Code401 : FailureResponse("Code401", "Code401")
}

sealed class OnExceptionError : ErrorType {
    object ExHttpException :
        FailureResponse("ExHttpException", "HttpException")
    object ExUnknownHostException :
        FailureResponse("ExUnknownHostException", "UnknownHostException")
    object ExSocketTimeoutException :
        FailureResponse("ExSocketTimeoutException", "SocketTimeoutException")
}