package com.pereyrarg11.drinks.feature.popular.data.repository

import com.pereyrarg11.drinks.core.data.remote.DrinkApi
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.di.EntityDetailConverter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.popular.domain.repository.PopularRepository
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PopularRepositoryImpl @Inject constructor(
    private val api: DrinkApi,
    @EntityDetailConverter private val converter: Converter<ResponseBodyDto<DrinkDto>, List<DrinkModel>>
) : PopularRepository {

    override suspend fun getPopularDrinks(): Flow<DataResult<List<DrinkModel>>> {
        return flow {
            emit(DataResult.Loading(isLoading = true))

            api.getPopularDrinks()
                .suspendOnSuccess {
                    // TODO: implement request caching
                    emit(DataResult.Success(converter.convert(data)))
                }
                .suspendOnError {
                    emit(DataResult.Error(exception = Exception("Error on popular drinks request")))
                }
                .suspendOnException {
                    emit(DataResult.Error(exception = Exception(message, throwable)))
                }
        }
    }
}
