package com.pereyrarg11.drinks.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DrinkDto(
    @SerializedName("idDrink") val idDrink: String?,
    @SerializedName("strDrink") val strDrink: String?,
    @SerializedName("strDrinkThumb") val strDrinkThumb: String?,
)
