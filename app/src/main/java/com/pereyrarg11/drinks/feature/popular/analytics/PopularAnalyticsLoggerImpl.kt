package com.pereyrarg11.drinks.feature.popular.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsEvent
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsParameter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PopularAnalyticsLoggerImpl @Inject constructor(
    private val analyticsLogger: AnalyticsLogger,
) : PopularAnalyticsLogger {

    override fun enterToScreen() {
        analyticsLogger.logEvent(
            AnalyticsEvent.SCREEN_VIEW,
            listOf(
                AnalyticsParameter.SCREEN_NAME to "PopularScreen"
            )
        )
    }

    override fun displayDrink(drinkId: String, drinkName: String) {
        analyticsLogger.logEvent(
            AnalyticsEvent.POPULAR_DRINK_DISPLAY,
            listOf(
                AnalyticsParameter.DRINK_ID to drinkId,
                AnalyticsParameter.DRINK_NAME to drinkName,
            )
        )
    }

    override fun clickDrink(drinkId: String, drinkName: String) {
        analyticsLogger.logEvent(
            AnalyticsEvent.POPULAR_DRINK_CLICK,
            listOf(
                AnalyticsParameter.DRINK_ID to drinkId,
                AnalyticsParameter.DRINK_NAME to drinkName,
            )
        )
    }
}
