package net.denis.weatherapp.core.presentation.error.handlers

import net.denis.weatherapp.core.presentation.error.model.FailureResponse

fun handleException(ex: Exception) =
    FailureResponse(errMessage = ex.localizedMessage, btnTitle = "Перезапустить приложение")