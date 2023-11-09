package com.pereyrarg11.drinks.feature.home.data.repository

import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.domain.repository.HomeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor() : HomeRepository {
    override suspend fun fetchContent(): Flow<DataResult<List<HomeSectionModel>>> {
        return flow {
            emit(DataResult.Loading())

            emit(
                DataResult.Success(
                    StaticHomeProvider.getAllSections()
                )
            )
        }
    }
}