package com.pereyrarg11.drinks.feature.drink.data.repository

import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.data.util.NoResultsFoundException
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.drink.data.remote.DrinkDetailApi
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkDetailDto
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import com.pereyrarg11.drinks.feature.drink.domain.repository.DrinkDetailRepository
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DrinkDetailRepositoryImpl @Inject constructor(
    private val api: DrinkDetailApi,
    private val responseConverter: Converter<ResponseBodyDto<DrinkDetailDto>, List<DrinkDetailModel>>,
) : DrinkDetailRepository {

    override suspend fun getDrinkById(id: String): Flow<DataResult<DrinkDetailModel>> {
        return flow {
            emit(DataResult.Loading(isLoading = true))

            api.getDrinkDetail(id).suspendOnSuccess {
                val drinks = responseConverter.convert(data)
                if (drinks.isNotEmpty()) {
                    emit(DataResult.Success(drinks[0]))
                } else {
                    emit(DataResult.Error(exception = NoResultsFoundException()))
                }
            }.suspendOnError {
                emit(
                    DataResult.Error(
                        exception = Exception("An error occurred when trying to fetch drink by id: $this")
                    )
                )
            }.suspendOnException {
                emit(DataResult.Error(exception = Exception(throwable)))
            }
        }
    }
}
