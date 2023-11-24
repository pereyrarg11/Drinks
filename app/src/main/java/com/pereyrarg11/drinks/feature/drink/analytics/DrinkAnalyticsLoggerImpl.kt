package com.pereyrarg11.drinks.feature.drink.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.Event
import com.pereyrarg11.drinks.core.logger.analytics.model.Parameter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkAnalyticsLoggerImpl @Inject constructor(
    private val analyticsLogger: AnalyticsLogger,
) : DrinkAnalyticsLogger {

    override fun enterToScreen(drinkId: String) {
        analyticsLogger.logEvent(
            Event.SCREEN_VIEW,
            listOf(
                Parameter.SCREEN_NAME to "DrinkScreen",
                Parameter.DRINK_ID to drinkId,
            )
        )
    }

    override fun clickTag(tagType: String, tagQuery: String) {
        analyticsLogger.logEvent(
            Event.TAG_CLICK,
            listOf(
                Parameter.TAG_TYPE to tagType,
                Parameter.TAG_QUERY to tagQuery,
            )
        )
    }
}
