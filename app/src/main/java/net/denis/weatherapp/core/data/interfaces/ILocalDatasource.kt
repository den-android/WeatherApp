package net.denis.weatherapp.core.data.interfaces

interface ILocalDatasource {
    suspend fun putData(params: Any?)
    suspend fun getData(): Any?
}