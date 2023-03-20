package net.denis.weatherapp.core.data.datasource.local

import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import javax.inject.Inject

class LocalDatasource @Inject constructor(
    private val dataBuffer: DataBuffer
) : ILocalDatasource {

    override suspend fun putData(params: Any?) {
        dataBuffer.setData(data = params)
    }

    override suspend fun getData(): Any? {
        return dataBuffer.getData()
    }

}