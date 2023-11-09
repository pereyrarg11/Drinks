package com.pereyrarg11.drinks.feature.drink.domain.usecase

import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import com.pereyrarg11.drinks.feature.drink.domain.repository.DrinkDetailRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDrinkUseCase @Inject constructor(
    private val repository: DrinkDetailRepository,
) {

    suspend operator fun invoke(id: String): Flow<DataResult<DrinkDetailModel>> =
        repository.getDrinkById(id)
}
