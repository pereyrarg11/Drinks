package com.pereyrarg11.drinks.feature.filter.analytics

interface FilterAnalyticsLogger {
    fun enterToScreen(filterType: String, query: String)

    fun clickDrink(drinkId: String, drinkName: String)
}
