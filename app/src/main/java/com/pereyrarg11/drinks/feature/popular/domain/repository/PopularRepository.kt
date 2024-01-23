package com.pereyrarg11.drinks.feature.popular.domain.repository

import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import kotlinx.coroutines.flow.Flow

interface PopularRepository {
    suspend fun getPopularDrinks(): Flow<DataResult<List<DrinkModel>>>
}
