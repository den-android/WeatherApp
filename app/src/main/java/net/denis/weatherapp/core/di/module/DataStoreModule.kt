package net.denis.weatherapp.core.di.module

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import net.denis.weatherapp.core.util.CityDataPreferencesSerializer
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import javax.inject.Singleton

private const val CITY_PREFERENCES_NAME = "city_preferences"
private const val DATA_STORE_FILE_NAME = "city_prefs.pb"

@InstallIn(SingletonComponent::class)
@Module
object DataStoreModule {

    @Singleton
    @Provides
    fun providePreferencesDataStore(
        @ApplicationContext context: Context,
        scopeIo: CoroutineScope
    ): DataStore<CityData> {
        return DataStoreFactory.create(
            serializer = CityDataPreferencesSerializer,
            produceFile = { context.dataStoreFile(DATA_STORE_FILE_NAME) },
            corruptionHandler = null,
            scope = CoroutineScope(context = scopeIo.coroutineContext)
        )
    }
}