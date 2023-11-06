package com.pereyrarg11.drinks.feature.filter.domain.repository

import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface FilterRepository {
    suspend fun filterDrinksByAlcohol(query: String): Flow<DataResult<List<DrinkModel>>>

    suspend fun filterDrinksByCategory(query: String): Flow<DataResult<List<DrinkModel>>>

    suspend fun filterDrinksByIngredient(query: String): Flow<DataResult<List<DrinkModel>>>
}
