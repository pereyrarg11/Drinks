package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

data class DrinkDisplayable(
    override val label: UiText,
    override val imageUrl: String,
    val id: String,
) : Displayable
