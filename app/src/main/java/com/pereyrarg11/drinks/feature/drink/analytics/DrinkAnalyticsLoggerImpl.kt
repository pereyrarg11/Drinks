package com.pereyrarg11.drinks.feature.drink.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.Event
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsParameter
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
                AnalyticsParameter.SCREEN_NAME to "DrinkScreen",
                AnalyticsParameter.DRINK_ID to drinkId,
            )
        )
    }

    override fun clickTag(tagType: String, tagQuery: String) {
        analyticsLogger.logEvent(
            Event.TAG_CLICK,
            listOf(
                AnalyticsParameter.TAG_TYPE to tagType,
                AnalyticsParameter.TAG_QUERY to tagQuery,
            )
        )
    }
}
