package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

// TODO: rename to DisplayableDetail
/**
 * Interface for all content to be displayed into a detail-screen.
 */
interface DetailDisplayable {
    val title: UiText
    val mediaUrl: String
}
