package net.denis.weatherapp.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.denis.weatherapp.core.data.datasource.local.DataBuffer
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataBufferModule {

    @Provides
    @Singleton
    fun provideDataBuffer() = DataBuffer()
}