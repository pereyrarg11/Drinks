package com.pereyrarg11.drinks.feature.home.domain.model

import com.pereyrarg11.drinks.core.domain.model.FilterType

data class HomeFilterModel(
    val label: String = "",
    val imageUrl: String = "",
    val type: FilterType = FilterType.UNKNOWN,
    val queryValue: String = "",
)
