package com.pereyrarg11.drinks.core.logger.analytics

interface AnalyticsLogger {
    fun logEvent(eventName: String, payload: List<Pair<String, String>>)

    interface Facade : AnalyticsLogger
}
