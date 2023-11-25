package com.pereyrarg11.drinks.feature.filter.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.Event
import com.pereyrarg11.drinks.core.logger.analytics.model.Parameter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilterAnalyticsLoggerImpl @Inject constructor(
    private val analyticsLogger: AnalyticsLogger,
) : FilterAnalyticsLogger {

    override fun enterToScreen(filterType: String, query: String) {
        analyticsLogger.logEvent(
            Event.SCREEN_VIEW,
            listOf(
                Parameter.SCREEN_NAME to "FilterScreen",
                Parameter.FILTER_TYPE to filterType,
                Parameter.FILTER_QUERY to query,
            )
        )
    }

    override fun clickDrink(drinkId: String, drinkName: String) {
        analyticsLogger.logEvent(
            Event.DRINK_CLICK,
            listOf(
                Parameter.DRINK_ID to drinkId,
                Parameter.DRINK_NAME to drinkName,
            )
        )
    }
}
