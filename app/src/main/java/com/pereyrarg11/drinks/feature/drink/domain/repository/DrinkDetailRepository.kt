package com.pereyrarg11.drinks.feature.drink.domain.repository

import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import kotlinx.coroutines.flow.Flow

interface DrinkDetailRepository {
    suspend fun getDrinkById(id: String): Flow<DataResult<DrinkDetailModel>>
}
