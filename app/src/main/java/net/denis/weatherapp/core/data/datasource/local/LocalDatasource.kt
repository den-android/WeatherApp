package net.denis.weatherapp.core.data.datasource.local

import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.util.Constants.DEFAULT_LAT
import net.denis.weatherapp.core.util.Constants.DEFAULT_LON
import net.denis.weatherapp.features.detail_forecast.model.DetailData
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import javax.inject.Inject

class LocalDatasource @Inject constructor(
    private val dataBuffer: DataBuffer
) : ILocalDatasource {
    override suspend fun writeDetailParams(detailData: DetailData) {
        dataBuffer.setData(detailData)
    }

    override suspend fun readDetailParams(): DetailData {
        return dataBuffer.getData() as DetailData
    }

    override suspend fun writeCityCoords(cityData: CityData) {
        dataBuffer.setData(cityData)
    }

    override suspend fun readCityCoords(): CityData {
        return dataBuffer.getData() as? CityData ?: CityData("Ростов на Дону", DEFAULT_LAT, DEFAULT_LON)
    }
}