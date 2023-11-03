package com.pereyrarg11.drinks.feature.home.domain.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

data class HomeSectionModel(
    val label: UiText = UiText.PlainText(""),
    val filters: List<HomeFilterModel> = emptyList(),
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
)
