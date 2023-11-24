package com.pereyrarg11.drinks.core.util.error


interface ErrorLogger {
    fun logException(exception: Exception)

    fun setProperties(properties: Map<String, String>)

    interface Facade : ErrorLogger
}
