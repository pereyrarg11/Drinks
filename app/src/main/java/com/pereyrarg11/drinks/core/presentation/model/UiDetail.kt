package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

/**
 * Interface for all content to be displayed into a detail-screen.
 */
interface UiDetail {
    val title: UiText
    val mediaUrl: String
}
