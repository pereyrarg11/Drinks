package com.pereyrarg11.drinks.core.util.error

import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.setCustomKeys
import com.google.firebase.ktx.Firebase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CrashlyticsErrorLogger @Inject constructor() : ErrorLogger.Facade {
    override fun logException(exception: Exception) {
        Firebase.crashlytics.recordException(exception)
    }

    override fun setProperties(properties: Map<String, String>) {
        Firebase.crashlytics.setCustomKeys {
            properties.entries.forEach { entry ->
                key(entry.key, entry.value)
            }
        }
    }
}
