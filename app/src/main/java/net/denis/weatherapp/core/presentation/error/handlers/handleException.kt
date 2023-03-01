package net.denis.weatherapp.core.presentation.error.handlers

import net.denis.weatherapp.core.presentation.error.model.FailureResponse
import retrofit2.HttpException
import java.net.ConnectException
import java.net.UnknownHostException

fun handleException(ex: Exception) : FailureResponse {
    return when (ex) {
        is HttpException -> {
            FailureResponse(ex.localizedMessage, "Перезапустить приложение")
        }

        is ConnectException -> {
            FailureResponse(errMessage = "Отсутствует подключение к сети Интернет", "Перезагрузить страницу")
        }

        is UnknownHostException -> {
            FailureResponse(errMessage = "Отсутствует подключение к сети Интернет", "Перезагрузить")
        }

        else -> {
            FailureResponse(ex.localizedMessage, "Перезапустить приложение")
        }
    }
}
  //  FailureResponse(errMessage = ex.localizedMessage, btnTitle = "Перезапустить приложение")