package com.pereyrarg11.drinks.feature.filter.data.repository

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkListDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.filter.data.remote.FilterApi
import com.pereyrarg11.drinks.feature.filter.domain.repository.FilterRepository
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FilterRepositoryImpl @Inject constructor(
    private val api: FilterApi,
    private val listConverter: Converter<DrinkListDto, List<DrinkModel>>,
) : FilterRepository {
    override suspend fun filterDrinksByAlcohol(query: String): Flow<DataResult<List<DrinkModel>>> {
        return handleApiResponse(api.filterDrinksByAlcohol(query))
    }

    override suspend fun filterDrinksByCategory(query: String): Flow<DataResult<List<DrinkModel>>> {
        return handleApiResponse(api.filterDrinksByCategory(query))
    }

    override suspend fun filterDrinksByIngredient(query: String): Flow<DataResult<List<DrinkModel>>> {
        return handleApiResponse(api.filterDrinksByIngredient(query))
    }

    private suspend fun handleApiResponse(apiResponse: ApiResponse<DrinkListDto>): Flow<DataResult<List<DrinkModel>>> {
        return flow {
            emit(DataResult.Loading(isLoading = true))

            apiResponse
                .suspendOnSuccess {
                    emit(DataResult.Success(listConverter.convert(this.data)))
                }
                .suspendOnError {
                    emit(DataResult.Error(exception = Exception("Couldn't load data")))
                }
                .suspendOnException {
                    emit(DataResult.Error(exception = Exception(this.throwable)))
                }
        }
    }
}
