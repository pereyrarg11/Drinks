package com.pereyrarg11.drinks.feature.drink.data.remote.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkIngredientModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkIngredientListConverter @Inject constructor(
    private val itemConverter: Converter<DrinkIngredientDto, DrinkIngredientModel>,
) : Converter<@JvmSuppressWildcards List<DrinkIngredientDto>, @JvmSuppressWildcards List<DrinkIngredientModel>> {

    override fun convert(input: List<DrinkIngredientDto>): List<DrinkIngredientModel> {
        return input
            .filter { it.strIngredient.isNullOrBlank().not() }
            .map { itemConverter.convert(it) }
    }
}
