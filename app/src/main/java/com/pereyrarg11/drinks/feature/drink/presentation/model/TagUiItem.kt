package com.pereyrarg11.drinks.feature.drink.presentation.model

import com.pereyrarg11.drinks.core.presentation.model.UiItem
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class TagUiItem(
    override val id: String = "",
    override val label: UiText = UiText.PlainText(""),
    override val imageUrl: String = "",
    val query: String = "",
    val type: DrinkTagType = DrinkTagType.UNKNOWN,
) : UiItem
