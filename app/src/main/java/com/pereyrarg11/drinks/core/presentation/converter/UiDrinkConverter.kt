package com.pereyrarg11.drinks.core.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.util.UiText
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkConverter @Inject constructor() : Converter<DrinkModel, DrinkDisplayable> {
    override fun convert(input: DrinkModel): DrinkDisplayable {
        return DrinkDisplayable(
            label = UiText.PlainText(input.name),
            imageUrl = input.imageUrl,
            id = input.id
        )
    }
}
