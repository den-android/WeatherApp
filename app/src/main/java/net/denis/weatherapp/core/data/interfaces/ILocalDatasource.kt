package net.denis.weatherapp.core.data.interfaces

import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.model.CityData

interface ILocalDatasource {
    suspend fun writeDetailParams(detailData: DetailData)
    suspend fun readDetailParams(): DetailData

    suspend fun writeCityCoords(cityData: CityData)
    suspend fun readCityCoords(): CityData
}