package com.pereyrarg11.drinks.feature.filter.presentation

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.util.UiText

// TODO: implement UiState
data class FilterState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val drinks: List<DrinkDisplayable> = emptyList(),
    val errorMessage: UiText = UiText.StringResource(R.string.error_default),
    val title: UiText = UiText.StringResource(R.string.title_drinks),
)
