package com.pereyrarg11.drinks.core.logger.debug

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugLoggerMediator @Inject constructor(
    private val facades: Set<@JvmSuppressWildcards DebugLogger.Facade>,
) : DebugLogger {

    override fun logMessage(tag: String, message: String) {
        facades.forEach { debugLogger ->
            debugLogger.logMessage(tag, message)
        }
    }

    override fun logMessage(tag: String, messageTemplate: () -> String) {
        facades.forEach { debugLogger ->
            debugLogger.logMessage(tag, messageTemplate)
        }
    }
}
