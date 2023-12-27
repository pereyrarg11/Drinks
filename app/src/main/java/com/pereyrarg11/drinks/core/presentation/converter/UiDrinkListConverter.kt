package com.pereyrarg11.drinks.core.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.di.EntitySummaryConverter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkListConverter @Inject constructor(
    @EntitySummaryConverter private val itemConverter: Converter<DrinkModel, DrinkUiItem>,
) : Converter<@JvmSuppressWildcards List<DrinkModel>, @JvmSuppressWildcards List<DrinkUiItem>> {

    override fun convert(input: List<DrinkModel>): List<DrinkUiItem> {
        return input.map { model -> itemConverter.convert(model) }
    }
}
