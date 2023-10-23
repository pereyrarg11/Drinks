package com.pereyrarg11.drinks.feature.home.domain.model

data class HomeSectionModel(
    val label: String = "",
    val filters: List<HomeFilterModel> = emptyList(),
    val type: HomeSectionType = HomeSectionType.UNKNOWN,
)
