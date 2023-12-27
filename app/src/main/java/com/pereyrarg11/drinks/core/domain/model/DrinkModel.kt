package com.pereyrarg11.drinks.core.domain.model

data class DrinkModel(
    val id: String = "",
    val name: String = "",
    val imageUrl: String = "",
    val category: String = "",
    val alcoholContent: String = "",
    val glass: String = "",
    val ingredients: List<DrinkIngredientModel> = emptyList(),
    val instructions: String = "",
)
