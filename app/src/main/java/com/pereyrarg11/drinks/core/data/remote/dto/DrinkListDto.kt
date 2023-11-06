package com.pereyrarg11.drinks.core.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DrinkListDto(
    @SerializedName("drinks") val drinks: List<DrinkDto>?,
)
