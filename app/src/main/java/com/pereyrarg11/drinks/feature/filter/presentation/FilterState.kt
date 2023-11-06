package com.pereyrarg11.drinks.feature.filter.presentation

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class FilterState(
    val isLoading: Boolean = false,
    val hasError: Boolean = false,
    val drinks: List<DrinkDisplayable> = emptyList(),
    val errorMessage: UiText = UiText.StringResource(R.string.error_default),
)
