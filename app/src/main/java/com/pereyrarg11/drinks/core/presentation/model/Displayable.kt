package com.pereyrarg11.drinks.core.presentation.model

import com.pereyrarg11.drinks.core.presentation.util.UiText

// TODO: this class could be renamed to Listable or something that describes an item into a list
// TODO: can an ID attribute be added? in order to enhance the list rendering
interface Displayable {
    val label: UiText
    val imageUrl: String
}
