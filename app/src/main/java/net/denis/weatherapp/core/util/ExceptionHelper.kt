package net.denis.weatherapp.core.util

import android.util.Log
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlin.coroutines.coroutineContext

internal suspend inline fun <T> getResult(block: () -> T): Result<T> = try {
    block().let { Result.success(it) }
} catch (e: Exception) {
    if (e is CancellationException) throw e
    Log.e("StackTrace Error","Error from coroutine (${coroutineContext[CoroutineName]?.name}): " +
            "${e.stackTraceToString()}")
    Result.failure(e)
}

inline fun <T> Flow<T>.catchLog(default: T? = null): Flow<T> = this.catch { e ->
    if (e is CancellationException) throw e
    Log.e(
        "StackTrace Error",
        "Error from flow (${coroutineContext[CoroutineName]?.name}): " +
                "${e.stackTraceToString()}"
    )
    default?.let { emit(it) }
}