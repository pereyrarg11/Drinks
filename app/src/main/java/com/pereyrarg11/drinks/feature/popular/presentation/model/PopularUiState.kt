package com.pereyrarg11.drinks.feature.popular.presentation.model

import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.model.UiState
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class PopularUiState(
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
    override val errorMessage: UiText = UiText.PlainText(""),
    val drinks: List<DrinkUiItem> = emptyList(),
) : UiState
