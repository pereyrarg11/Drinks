package com.pereyrarg11.drinks.feature.filter.presentation.model

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.model.UiState
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class FilterUiState(
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
    override val errorMessage: UiText = UiText.PlainText(""),
    val drinks: List<DrinkUiItem> = emptyList(),
    val title: UiText = UiText.StringResource(R.string.title_drinks),
) : UiState
