package net.denis.weatherapp.core.util

import androidx.datastore.core.Serializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import net.denis.weatherapp.features.fetch_new_city.model.CityData
import java.io.InputStream
import java.io.OutputStream

object CityDataPreferencesSerializer: Serializer<CityData> {
    override val defaultValue: CityData
        get() = CityData(name = "Ростов на Дону", lat = 47.2213858, lon = 39.7114196)

    override suspend fun readFrom(input: InputStream): CityData {
        return try {
            Json.decodeFromString(
                deserializer = CityData.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e: SerializationException) {
            e.printStackTrace()
            defaultValue
        }
    }

    override suspend fun writeTo(t: CityData, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = CityData.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}