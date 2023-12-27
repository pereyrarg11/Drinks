package com.pereyrarg11.drinks.feature.drink.domain.repository

import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface DrinkDetailRepository {
    suspend fun getDrinkById(id: String): Flow<DataResult<DrinkModel>>
}
