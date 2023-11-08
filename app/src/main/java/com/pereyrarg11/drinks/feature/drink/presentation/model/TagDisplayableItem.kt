package com.pereyrarg11.drinks.feature.drink.presentation.model

import com.pereyrarg11.drinks.core.presentation.model.DisplayableItem
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class TagDisplayableItem(
    override val id: String = "",
    override val label: UiText = UiText.PlainText(""),
    override val imageUrl: String = "",
    val query: String = "",
    val type: DrinkTagType = DrinkTagType.UNKNOWN,
) : DisplayableItem
