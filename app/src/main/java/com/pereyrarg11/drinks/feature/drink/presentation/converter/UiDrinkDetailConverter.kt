package com.pereyrarg11.drinks.feature.drink.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.use_case.EscapeTextUseCase
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkDetailDisplayable
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkTagType
import com.pereyrarg11.drinks.feature.drink.presentation.model.TagDisplayableItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkDetailConverter @Inject constructor(
    val escapeText: EscapeTextUseCase,
) : Converter<DrinkDetailModel, DrinkDetailDisplayable> {

    // FIXME: remove line-breaks from text, look at this case:
    //  https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=17221
    override fun convert(input: DrinkDetailModel): DrinkDetailDisplayable {
        return DrinkDetailDisplayable(
            title = UiText.PlainText(input.name),
            mediaUrl = input.media.thumbUrl,
            glassLabel = UiText.PlainText(input.glass),
            ingredients = input.ingredients.map { UiText.PlainText(it.toString()) },
            instructions = UiText.PlainText(input.instructions),
            tags = generateTags(input),
        )
    }

    /**
     * This approach is temporary.
     * Implement a [Converter] if the data becomes bigger.
     */
    private fun generateTags(input: DrinkDetailModel): List<TagDisplayableItem> {
        return listOf(
            TagDisplayableItem(
                id = "1",
                label = UiText.PlainText(input.alcoholContent),
                query = escapeText(input.alcoholContent),
                type = DrinkTagType.ALCOHOL,
            ),
            TagDisplayableItem(
                id = "2",
                label = UiText.PlainText(input.category),
                query = escapeText(input.category),
                type = DrinkTagType.CATEGORY,
            ),
        ).filter { it.query.isNotBlank() }
    }
}
