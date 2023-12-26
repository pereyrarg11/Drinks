package com.pereyrarg11.drinks.core.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkIngredientModel
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkDetailConverter @Inject constructor(
    private val ingredientsConverter: Converter<List<DrinkIngredientDto>, List<DrinkIngredientModel>>,
) : Converter<DrinkDto, DrinkModel> {

    override fun convert(input: DrinkDto): DrinkModel {
        return DrinkModel(
            id = input.idDrink.orEmpty(),
            name = input.strDrink.orEmpty(),
            imageUrl = input.strDrinkThumb.orEmpty(),
            category = input.strCategory.orEmpty(),
            alcoholContent = input.strAlcoholic.orEmpty(),
            glass = input.strGlass.orEmpty(),
            ingredients = convertIngredients(input),
            instructions = input.strInstructions.orEmpty(),
        )
    }

    private fun convertIngredients(input: DrinkDto): List<DrinkIngredientModel> {
        val ingredientsDto = listOf(
            DrinkIngredientDto(input.strIngredient1, input.strMeasure1),
            DrinkIngredientDto(input.strIngredient2, input.strMeasure2),
            DrinkIngredientDto(input.strIngredient3, input.strMeasure3),
            DrinkIngredientDto(input.strIngredient4, input.strMeasure4),
            DrinkIngredientDto(input.strIngredient5, input.strMeasure5),
            DrinkIngredientDto(input.strIngredient6, input.strMeasure6),
            DrinkIngredientDto(input.strIngredient7, input.strMeasure7),
            DrinkIngredientDto(input.strIngredient8, input.strMeasure8),
            DrinkIngredientDto(input.strIngredient9, input.strMeasure9),
            DrinkIngredientDto(input.strIngredient10, input.strMeasure10),
            DrinkIngredientDto(input.strIngredient11, input.strMeasure11),
            DrinkIngredientDto(input.strIngredient12, input.strMeasure12),
            DrinkIngredientDto(input.strIngredient13, input.strMeasure13),
            DrinkIngredientDto(input.strIngredient14, input.strMeasure14),
            DrinkIngredientDto(input.strIngredient15, input.strMeasure15),
        )

        return ingredientsConverter.convert(ingredientsDto)
    }
}
