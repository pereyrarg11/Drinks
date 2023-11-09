package com.pereyrarg11.drinks.feature.drink.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkDetailDto
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ResponseDrinkDetailConverter @Inject constructor(
    private val itemConverter: Converter<DrinkDetailDto, DrinkDetailModel>,
) : Converter<ResponseBodyDto<DrinkDetailDto>, @JvmSuppressWildcards List<DrinkDetailModel>> {

    override fun convert(input: ResponseBodyDto<DrinkDetailDto>): List<DrinkDetailModel> {
        if (!input.drinks.isNullOrEmpty()) {
            return input.drinks
                .map { dto -> itemConverter.convert(dto) }
                .filter { model -> model.id.isNotBlank() && model.name.isNotBlank() }
        }

        return emptyList()
    }
}
