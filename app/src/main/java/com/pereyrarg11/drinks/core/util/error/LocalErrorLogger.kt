package com.pereyrarg11.drinks.core.util.error

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalErrorLogger @Inject constructor() : ErrorLogger.Facade {
    private val logTag = "LocalErrorLogger"

    override fun logException(exception: Exception) {
        Log.w(logTag, exception)
    }

    override fun setProperties(properties: Map<String, String>) {
        val propertiesAsString = properties.entries.joinToString(", ") { entry ->
            "${entry.key}:${entry.value}"
        }
        Log.d(logTag, propertiesAsString)
    }
}
