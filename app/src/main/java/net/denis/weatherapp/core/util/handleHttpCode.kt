package net.denis.weatherapp.core.util

fun handleHttpCode(code: Int): FailureResponse {
    return when (code) {
        401 -> {
            FailureResponse(
                errMessage = "Unauthorized call",
                actionTitle = "fix 401 error"
            )
        }
        404 -> {
            FailureResponse(
                errMessage = "page not found",
                actionTitle = "fix 404 error"
            )
        }
        else -> FailureResponse(errMessage = "Unexpected error", actionTitle = "Перезапустить приложение")
    }
}