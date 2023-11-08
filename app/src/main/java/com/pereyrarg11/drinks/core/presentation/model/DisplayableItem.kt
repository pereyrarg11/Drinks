package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

/**
 * Contains the minimum attributes which an item must have in order to be displayed into a list.
 * All list-items data MUST implement this interface.
 */
interface DisplayableItem {
    val id: String
    val label: UiText
    val imageUrl: String
}
