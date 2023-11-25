package com.pereyrarg11.drinks.core.logger.analytics

import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DebugAnalyticsLoggerFacade @Inject constructor() : AnalyticsLogger.Facade {
    // TODO: inject DebugLogger (it does not exist yet)
    override fun logEvent(eventName: String, payload: List<Pair<String, String>>) {
        val payloadAsString = payload.joinToString(", ") { "${it.first}:${it.second}" }
        Log.d("AnalyticsLogger", "event:$eventName, payload:{$payloadAsString}")
    }
}
