package com.pereyrarg11.drinks.feature.drink.presentation.model

import com.pereyrarg11.drinks.core.presentation.model.UiDetail
import com.pereyrarg11.drinks.core.presentation.util.UiText

data class DrinkUiDetail(
    override val title: UiText = UiText.PlainText(""),
    override val mediaUrl: String = "",
    val glassLabel: UiText = UiText.PlainText(""),
    val ingredients: List<UiText> = emptyList(),
    val instructions: UiText = UiText.PlainText(""),
    val tags: List<TagUiItem> = emptyList(),
) : UiDetail
