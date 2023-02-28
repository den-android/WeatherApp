package net.denis.weatherapp.core.presentation.error.handlers

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import retrofit2.HttpException

fun handleException(ex: Exception) : FailureResponse {
    return when (ex) {
        is HttpException -> {
            FailureResponse(ex.localizedMessage, "Перезапустить приложение")
        }

        else -> {
            FailureResponse(ex.localizedMessage, "Перезапустить приложение")
        }
    }
}
  //  FailureResponse(errMessage = ex.localizedMessage, btnTitle = "Перезапустить приложение")