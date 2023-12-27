package com.pereyrarg11.drinks.core.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.usecase.EscapeTextUseCase
import com.pereyrarg11.drinks.core.domain.usecase.RemoveLineBreaksUseCase
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkTagType
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkUiDetail
import com.pereyrarg11.drinks.feature.drink.presentation.model.TagUiItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkDetailConverter @Inject constructor(
    val escapeText: EscapeTextUseCase,
    val removeLineBreaks: RemoveLineBreaksUseCase,
) : Converter<DrinkModel, DrinkUiDetail> {

    override fun convert(input: DrinkModel): DrinkUiDetail {
        return DrinkUiDetail(
            title = UiText.PlainText(input.name),
            mediaUrl = input.imageUrl,
            glassLabel = UiText.PlainText(input.glass),
            ingredients = input.ingredients.map { ingredient ->
                UiText.PlainText(removeLineBreaks(ingredient.toString()))
            },
            instructions = UiText.PlainText(removeLineBreaks(input.instructions)),
            tags = generateTags(input),
        )
    }

    /**
     * This approach is temporary.
     * Implement a [Converter] if the data becomes bigger.
     */
    private fun generateTags(input: DrinkModel): List<TagUiItem> {
        return listOf(
            TagUiItem(
                id = "1",
                label = UiText.PlainText(input.alcoholContent),
                query = escapeText(input.alcoholContent),
                type = DrinkTagType.ALCOHOL,
            ),
            TagUiItem(
                id = "2",
                label = UiText.PlainText(input.category),
                query = escapeText(input.category),
                type = DrinkTagType.CATEGORY,
            ),
        ).filter { it.query.isNotBlank() }
    }
}
