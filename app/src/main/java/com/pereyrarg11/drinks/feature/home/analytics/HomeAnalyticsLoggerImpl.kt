package com.pereyrarg11.drinks.feature.home.analytics

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsEvent
import com.pereyrarg11.drinks.core.logger.analytics.model.AnalyticsParameter
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeAnalyticsLoggerImpl @Inject constructor(
    private val analyticsLogger: AnalyticsLogger,
) : HomeAnalyticsLogger {

    override fun enterScreen() {
        analyticsLogger.logEvent(
            AnalyticsEvent.SCREEN_VIEW,
            listOf(
                AnalyticsParameter.SCREEN_NAME to "HomeScreen",
            )
        )
    }

    override fun clickFilter(homeFilter: HomeFilterModel) {
        analyticsLogger.logEvent(
            AnalyticsEvent.HOME_FILTER_CLICK,
            listOf(
                AnalyticsParameter.FILTER_TYPE to homeFilter.type.name,
                AnalyticsParameter.FILTER_QUERY to homeFilter.query,
            )
        )
    }
}
