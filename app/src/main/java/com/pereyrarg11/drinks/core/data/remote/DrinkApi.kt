package com.pereyrarg11.drinks.core.data.remote

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface DrinkApi {
    @GET("popular.php")
    suspend fun getPopularDrinks(): ApiResponse<ResponseBodyDto<DrinkDto>>
}
