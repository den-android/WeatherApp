package net.denis.weatherapp.features.fetch_new_city.mvi

import android.util.Log
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.toEnCity
import net.denis.weatherapp.core.data.datasource.remote.dto.geocoding.toRuCity
import net.denis.weatherapp.core.data.interfaces.IGeocodingRepository
import net.denis.weatherapp.core.presentation.navigation.INavigationCommand
import net.denis.weatherapp.core.presentation.navigation.NavigationManager
import net.denis.weatherapp.core.presentation.redux.Middleware
import net.denis.weatherapp.core.presentation.redux.Store
import net.denis.weatherapp.core.util.FailureResponse
import net.denis.weatherapp.core.util.OnExceptionError
import net.denis.weatherapp.core.util.OnHttpError
import net.denis.weatherapp.core.util.network.NetworkResult
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import retrofit2.HttpException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class FetchCityDataMiddleware(
    private val geocodingRepository: IGeocodingRepository,
    private val navigationManager: NavigationManager
) : Middleware<FetchCityState, FetchCityAction> {
    override suspend fun process(
        action: FetchCityAction,
        currentState: FetchCityState,
        store: Store<FetchCityState, FetchCityAction>
    ) {
        when (action) {

            is FetchCityAction.FetchCity -> {
                fetchNewCity(cityName = action.name, store = store)
            }

            is FetchCityAction.NavigateTo<*> -> {
                navigateWithParams(params = action.params, destination = action.destination)
            }

            is FetchCityAction.OnActionErrorClicked -> {
                handlerErrors(currentState.failureResponse, store)
            }

            else -> currentState
        }
    }

    private suspend fun fetchNewCity(
        cityName: String, store: Store<FetchCityState, FetchCityAction>
    ) {
        geocodingRepository.fetchNewCity(cityName).collect() { response ->
            when (response) {
                is NetworkResult.Success -> {
                    response.data.forEach { cityItem ->
                        try {
                            store.dispatch(FetchCityAction.CityLoaded(cityData = cityItem.toRuCity()))
                        } catch (e: Exception) {
                            store.dispatch(FetchCityAction.CityLoaded(cityData = cityItem.toEnCity()))
                        }
                    }
                }
                is NetworkResult.Failure -> {
                    handlerHttpCode(response.code, store)
                }
                is NetworkResult.Exception -> {
                    handlerException(response.e, store)
                }
            }
        }
    }

    private suspend fun navigateWithParams(params: Any?, destination: INavigationCommand) {
        when (params) {
            is CityData -> {
                writeCoords(cityData = params)
            }
        }
        navigationManager.navigate(directions = destination)
    }

    private suspend fun writeCoords(cityData: CityData) {
        geocodingRepository.writeCityCoords(cityData = cityData)
    }

    private suspend fun handlerErrors(
        failureResponse: FailureResponse?, store: Store<FetchCityState, FetchCityAction>
    ) {
        when (failureResponse) {
            OnHttpError.Code1 -> {}
            OnHttpError.Code2 -> {}
            OnHttpError.Code401 -> {}

            OnExceptionError.ExUnknownHostException -> {
                store.dispatch(FetchCityAction.ClearErrorState)
            }
            OnExceptionError.ExSocketTimeoutException -> {
                store.dispatch(FetchCityAction.ClearErrorState)
            }
            OnExceptionError.ExHttpException -> {
                store.dispatch(FetchCityAction.ClearErrorState)
            }
            null -> Log.d("Logging", "FetchCityAction.OnActionErrorClicked -> null")
        }
    }

    private suspend fun handlerHttpCode(code: Int, store: Store<FetchCityState, FetchCityAction>) {
        when (code) {
            1 -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnHttpError.Code1))
            }
            2 -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnHttpError.Code2))
            }
            401 -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnHttpError.Code401))
            }
        }
    }

    private suspend fun handlerException(
        ex: Exception, store: Store<FetchCityState, FetchCityAction>
    ) {
        when (ex) {
            is UnknownHostException -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnExceptionError.ExUnknownHostException))
            }
            is SocketTimeoutException -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnExceptionError.ExSocketTimeoutException))
            }
            is HttpException -> {
                store.dispatch(FetchCityAction.SendErrorToUI(OnExceptionError.ExHttpException))
            }
        }
    }
}