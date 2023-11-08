package com.pereyrarg11.drinks.feature.drink.domain.model

data class DrinkIngredientModel(
    val name: String = "",
    val measure: String = "",
) {

    override fun toString(): String {
        if (measure.isNotBlank()) {
            return "$measure $name"
        }

        return name
    }
}
