package net.denis.weatherapp.core.presentation.error.handlers

import net.denis.weatherapp.core.presentation.error.model.FailureResponse

fun handleHttpCode(code: Int): FailureResponse {
    return when (code) {
        401 -> {
            FailureResponse(
                errMessage = "Unauthorized call",
                btnTitle = "Попробовать снова"
            )
        }
        404 -> {
            FailureResponse(
                errMessage = "page not found",
                btnTitle = "Повторить"
            )
        }
        else -> FailureResponse(
            errMessage = "Unexpected error",
            btnTitle = "Перезапустить приложение"
        )
    }
}