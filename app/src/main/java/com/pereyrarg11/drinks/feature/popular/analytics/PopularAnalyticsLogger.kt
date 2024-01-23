package com.pereyrarg11.drinks.feature.popular.analytics

interface PopularAnalyticsLogger {
    fun enterToScreen()

    // TODO: is this the best name?
    fun displayDrink(drinkId: String, drinkName: String)

    fun clickDrink(drinkId: String, drinkName: String)
}
