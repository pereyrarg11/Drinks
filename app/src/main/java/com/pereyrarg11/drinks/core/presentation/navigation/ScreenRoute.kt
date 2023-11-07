package com.pereyrarg11.drinks.core.presentation.navigation

import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants.FILTER_TYPE_PARAM
import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants.QUERY_PARAM

sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute("home")

    object Filter :
        ScreenRoute("filter?filterType={$FILTER_TYPE_PARAM}&query={$QUERY_PARAM}") {
        fun createRoute(filterType: String, query: String) =
            "filter?filterType=$filterType&query=$query"
    }
}
