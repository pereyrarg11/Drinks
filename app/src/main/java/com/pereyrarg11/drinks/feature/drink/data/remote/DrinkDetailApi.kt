package com.pereyrarg11.drinks.feature.drink.data.remote

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DrinkDetailApi {
    @GET("lookup.php")
    suspend fun getDrinkDetail(
        @Query("i") id: String,
    ): ApiResponse<ResponseBodyDto<DrinkDto>>
}
