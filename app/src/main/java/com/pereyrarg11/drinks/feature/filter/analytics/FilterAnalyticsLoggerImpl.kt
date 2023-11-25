package com.pereyrarg11.drinks.feature.filter.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.Event
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsParameter
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
                AnalyticsParameter.SCREEN_NAME to "FilterScreen",
                AnalyticsParameter.FILTER_TYPE to filterType,
                AnalyticsParameter.FILTER_QUERY to query,
            )
        )
    }

    override fun clickDrink(drinkId: String, drinkName: String) {
        analyticsLogger.logEvent(
            Event.DRINK_CLICK,
            listOf(
                AnalyticsParameter.DRINK_ID to drinkId,
                AnalyticsParameter.DRINK_NAME to drinkName,
            )
        )
    }
}
