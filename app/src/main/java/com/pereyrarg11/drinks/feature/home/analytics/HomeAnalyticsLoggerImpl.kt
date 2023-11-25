package com.pereyrarg11.drinks.feature.home.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.Event
import com.pereyrarg11.drinks.core.logger.analytics.model.Parameter
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeAnalyticsLoggerImpl @Inject constructor(
    private val analyticsLogger: AnalyticsLogger,
) : HomeAnalyticsLogger {

    override fun enterScreen() {
        analyticsLogger.logEvent(
            Event.SCREEN_VIEW,
            listOf(
                Parameter.SCREEN_NAME to "HomeScreen",
            )
        )
    }

    override fun clickFilter(homeFilter: HomeFilterModel) {
        analyticsLogger.logEvent(
            Event.HOME_FILTER_CLICK,
            listOf(
                Parameter.FILTER_TYPE to homeFilter.type.name,
                Parameter.FILTER_QUERY to homeFilter.query,
            )
        )
    }
}
