package com.pereyrarg11.drinks.core.logger.analytics

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsLoggerMediator @Inject constructor(
    private val facades: Set<@JvmSuppressWildcards AnalyticsLogger.Facade>,
) : AnalyticsLogger {

    override fun logEvent(eventName: String, payload: List<Pair<String, String>>) {
        facades.forEach { analyticsLogger ->
            analyticsLogger.logEvent(eventName, payload)
        }
    }
}
