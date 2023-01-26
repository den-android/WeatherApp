package net.denis.weatherapp.features.forecast.mvi

import net.denis.weatherapp.core.presentation.redux.Action
import net.denis.weatherapp.features.forecast.model.MeteorologyItem

sealed class ForecastAction : Action {

    object ForecastLoading : ForecastAction()
    data class ForecastLoaded(val meteorologyItem: MeteorologyItem) : ForecastAction()

}