package com.pereyrarg11.drinks.core.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.util.UiText
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkConverter @Inject constructor() : Converter<DrinkModel, DrinkUiItem> {
    override fun convert(input: DrinkModel): DrinkUiItem {
        return DrinkUiItem(
            label = UiText.PlainText(input.name),
            imageUrl = input.imageUrl,
            id = input.id
        )
    }
}
