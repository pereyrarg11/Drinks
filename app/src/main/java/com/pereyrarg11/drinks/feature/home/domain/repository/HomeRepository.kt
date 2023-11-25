package com.pereyrarg11.drinks.feature.home.domain.repository

import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun fetchContent(): Flow<DataResult<List<HomeSectionModel>>>
}
