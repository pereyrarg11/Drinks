package com.pereyrarg11.drinks.core.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkIngredientModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkIngredientConverter @Inject constructor() :
    Converter<DrinkIngredientDto, DrinkIngredientModel> {

    override fun convert(input: DrinkIngredientDto): DrinkIngredientModel {
        return DrinkIngredientModel(
            name = input.strIngredient.orEmpty(),
            measure = input.strMeasure.orEmpty(),
        )
    }
}
