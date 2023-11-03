package com.pereyrarg11.drinks.feature.home.presentation

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel

data class HomeState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val sections: List<HomeSectionModel> = emptyList(),
    val errorMessage: UiText = UiText.StringResource(R.string.error_default),
)
