package net.denis.weatherapp.core.data.datasource.local

import javax.inject.Inject

class DataBuffer @Inject constructor() {
    private var localData = Any()

    fun setData(data: Any) {
        localData = data
    }

    fun getData(): Any {
        val localD = localData
        localData = Any()
        return localD
    }
}