package com.pereyrarg11.drinks.feature.filter.data.remote

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface FilterApi {
    @GET("filter.php")
    suspend fun filterDrinksByAlcohol(
        @Query("a") query: String,
    ): ApiResponse<ResponseBodyDto<DrinkDto>>

    @GET("filter.php")
    suspend fun filterDrinksByCategory(
        @Query("c") query: String,
    ): ApiResponse<ResponseBodyDto<DrinkDto>>

    @GET("filter.php")
    suspend fun filterDrinksByIngredient(
        @Query("i") query: String,
    ): ApiResponse<ResponseBodyDto<DrinkDto>>
}
