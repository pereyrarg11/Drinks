package com.pereyrarg11.drinks.core.logger.analytics

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.logEvent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAnalyticsLoggerFacade @Inject constructor(
    private val firebaseAnalytics: FirebaseAnalytics,
) : AnalyticsLogger.Facade {

    override fun logEvent(eventName: String, payload: List<Pair<String, String>>) {
        firebaseAnalytics.logEvent(eventName) {
            payload.forEach { pair ->
                param(pair.first, pair.second)
            }
        }
    }
}
