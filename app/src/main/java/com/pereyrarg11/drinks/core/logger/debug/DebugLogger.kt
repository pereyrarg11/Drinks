package com.pereyrarg11.drinks.core.logger.debug

interface DebugLogger {
    fun logMessage(tag: String, message: String)

    fun logMessage(tag: String, messageTemplate: () -> String)

    interface Facade : DebugLogger
}
