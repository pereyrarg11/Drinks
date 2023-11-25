package com.pereyrarg11.drinks.core.logger.debug

import com.google.firebase.crashlytics.FirebaseCrashlytics
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CrashlyticsDebugLogger @Inject constructor(
    private val firebaseCrashlytics: FirebaseCrashlytics,
) : DebugLogger.Facade {

    override fun logMessage(tag: String, message: String) {
        firebaseCrashlytics.log("$tag: $message")
    }

    override fun logMessage(tag: String, messageTemplate: () -> String) {
        logMessage(tag, messageTemplate())
    }
}
