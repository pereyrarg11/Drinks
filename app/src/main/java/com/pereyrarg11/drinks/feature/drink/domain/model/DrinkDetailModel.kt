package com.pereyrarg11.drinks.feature.drink.domain.model

data class DrinkDetailModel(
    val id: String = "",
    val name: String = "",
    val category: String = "",
    val alcoholContent: String = "",
    val glass: String = "",
    val ingredients: List<DrinkIngredientModel> = emptyList(),
    val media: DrinkMediaModel = DrinkMediaModel(),
    val instructions: String = "",
)
