package net.denis.weatherapp.core.presentation.error.model

import java.lang.Exception

fun handleException(ex: Exception)= FailureResponse(errMessage = ex.localizedMessage, btnTitle = "Перезапустить приложение")