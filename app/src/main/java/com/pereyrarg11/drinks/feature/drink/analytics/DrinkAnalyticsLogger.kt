package com.pereyrarg11.drinks.feature.drink.analytics

interface DrinkAnalyticsLogger {
    fun enterToScreen(drinkId: String)

    fun clickTag(tagType: String, tagQuery: String)
}
