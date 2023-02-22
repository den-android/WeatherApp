package net.denis.weatherapp.core.util

import net.denis.weatherapp.core.presentation.error.model.FailureResponse

fun handleHttpCode(code: Int): FailureResponse {
    return when (code) {
        401 -> {
            FailureResponse(
                errMessage = "Unauthorized call",
                btnTitle = "fix 401 error"
            )
        }
        404 -> {
            FailureResponse(
                errMessage = "page not found",
                btnTitle = "fix 404 error"
            )
        }
        else -> FailureResponse(errMessage = "Unexpected error", btnTitle = "Перезапустить приложение")
    }
}