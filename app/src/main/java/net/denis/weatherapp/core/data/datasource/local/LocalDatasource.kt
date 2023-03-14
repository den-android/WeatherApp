package net.denis.weatherapp.core.data.datasource.local

import kotlinx.coroutines.CoroutineScope
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import javax.inject.Inject

class LocalDatasource @Inject constructor(
    private val scopeIO: CoroutineScope
) : ILocalDatasource {

}