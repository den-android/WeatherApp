package net.denis.weatherapp.core.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import net.denis.weatherapp.core.presentation.navigation.NavigationManager
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesNavigationManager(coroutineScope: CoroutineScope) = NavigationManager(coroutineScope)
}