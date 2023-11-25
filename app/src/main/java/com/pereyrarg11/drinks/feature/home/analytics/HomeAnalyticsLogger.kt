package com.pereyrarg11.drinks.feature.home.analytics

import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel

interface HomeAnalyticsLogger {
    fun enterScreen()

    fun clickFilter(homeFilter: HomeFilterModel)
}
