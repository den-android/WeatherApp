package net.denis.weatherapp.core.di.module

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.weatherapp.core.data.datasource.local.LocalDatasource
import net.denis.weatherapp.core.data.datasource.remote.RemoteDatasource
import net.denis.weatherapp.core.data.interfaces.ILocalDatasource
import net.denis.weatherapp.core.data.interfaces.IRemoteDatasource
import net.denis.weatherapp.core.data.interfaces.IWeatherRepository
import net.denis.weatherapp.core.data.repository.WeatherRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindIWeatherRepository(weatherRepository: WeatherRepository): IWeatherRepository

    @Binds
    @Singleton
    abstract fun bindIRemoteDataSource(remoteDataSource: RemoteDatasource): IRemoteDatasource

    @Binds
    @Singleton
    abstract fun bindILocalDataSource(localDataSource: LocalDatasource): ILocalDatasource
}