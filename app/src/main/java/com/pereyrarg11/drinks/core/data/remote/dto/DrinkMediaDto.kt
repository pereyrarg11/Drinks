package com.pereyrarg11.drinks.core.data.remote.dto

/**
 * Data model to contain all attributes related to media sources for a drink.
 * This class does not represent a remote entity.
 */
data class DrinkMediaDto(
    val strDrinkThumb: String? = null,
    val strVideo: String? = null,
    val strImageSource: String? = null,
    val strImageAttribution: String? = null,
)
