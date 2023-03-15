package net.denis.weatherapp.core.data.datasource.local

import javax.inject.Inject

class DataBuffer @Inject constructor() {
    private var bufferData = Any()

    fun setData(data: Any) {
        bufferData = data
    }

    fun getData(): Any {
        val newData = bufferData
        bufferData = Any()
        return newData
    }
}