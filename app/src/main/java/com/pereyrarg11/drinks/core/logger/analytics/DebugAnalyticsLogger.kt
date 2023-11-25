package com.pereyrarg11.drinks.core.logger.analytics

import com.pereyrarg11.drinks.core.logger.debug.DebugLogger
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugAnalyticsLogger @Inject constructor(
    private val debugLogger: DebugLogger,
) : AnalyticsLogger.Facade {

    override fun logEvent(eventName: String, payload: List<Pair<String, String>>) {
        val payloadAsString = payload.joinToString(", ") { "${it.first}:${it.second}" }

        debugLogger.logMessage("AnalyticsLogger") {
            "event:$eventName, payload:{$payloadAsString}"
        }
    }
}
