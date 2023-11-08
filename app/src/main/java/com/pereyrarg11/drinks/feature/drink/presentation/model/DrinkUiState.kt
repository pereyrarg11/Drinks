package com.pereyrarg11.drinks.feature.drink.presentation.model

import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.model.UiState
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class DrinkUiState(
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
    override val errorMessage: UiText = UiText.StringResource(R.string.error_default),
    val drink: DrinkDetailDisplayable = DrinkDetailDisplayable(),
    val title: UiText = UiText.StringResource(R.string.title_drink),
) : UiState
