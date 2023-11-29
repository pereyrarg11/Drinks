package com.pereyrarg11.drinks.core.logger.error

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.google.firebase.crashlytics.setCustomKeys
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CrashlyticsErrorLogger @Inject constructor(
    private val firebaseCrashlytics: FirebaseCrashlytics,
) : ErrorLogger.Facade {

    override fun logException(exception: Exception) {
        firebaseCrashlytics.recordException(exception)
    }

    override fun setProperties(properties: Map<String, String>) {
        firebaseCrashlytics.setCustomKeys {
            properties.entries.forEach { entry ->
                key(entry.key, entry.value)
            }
        }
    }
}
