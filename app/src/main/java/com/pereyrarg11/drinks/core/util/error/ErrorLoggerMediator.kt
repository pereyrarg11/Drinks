package com.pereyrarg11.drinks.core.util.error

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorLoggerMediator @Inject constructor(
    private val facades: Set<@JvmSuppressWildcards ErrorLogger.Facade>,
) : ErrorLogger {

    override fun logException(exception: Exception) {
        facades.forEach { errorLogger ->
            errorLogger.logException(exception)
        }
    }

    override fun setProperties(properties: Map<String, String>) {
        facades.forEach { errorLogger ->
            errorLogger.setProperties(properties)
        }
    }
}
