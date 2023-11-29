package com.pereyrarg11.drinks.core.logger.error


interface ErrorLogger {
    fun logException(exception: Exception)

    fun setProperties(properties: Map<String, String>)

    interface Facade : ErrorLogger
}
