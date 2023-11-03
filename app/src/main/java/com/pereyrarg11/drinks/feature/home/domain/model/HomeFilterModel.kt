package com.pereyrarg11.drinks.feature.home.domain.model

import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class HomeFilterModel(
    val label: UiText = UiText.PlainText(""),
    val imageUrl: String = "",
    val type: FilterType = FilterType.UNKNOWN,
    val queryValue: String = "",
)
