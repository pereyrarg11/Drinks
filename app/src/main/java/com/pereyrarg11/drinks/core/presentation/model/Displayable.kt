package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

@Deprecated("Use UiItem instead.")
interface Displayable {
    val label: UiText
    val imageUrl: String
}
