package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

data class DrinkUiItem(
    override val label: UiText,
    override val imageUrl: String,
    override val id: String,
) : UiItem
