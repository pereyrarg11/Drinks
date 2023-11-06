package com.pereyrarg11.drinks.core.presentation.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UiDrinkListConverter @Inject constructor(
    private val itemConverter: Converter<DrinkModel, DrinkDisplayable>,
) : Converter<@JvmSuppressWildcards List<DrinkModel>, @JvmSuppressWildcards List<DrinkDisplayable>> {
    override fun convert(input: List<DrinkModel>): List<DrinkDisplayable> {
        return input.map { model -> itemConverter.convert(model) }
    }
}
