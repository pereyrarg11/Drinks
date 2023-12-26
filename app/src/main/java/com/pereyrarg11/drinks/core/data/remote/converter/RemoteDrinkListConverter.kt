package com.pereyrarg11.drinks.core.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.di.ListItemConverter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkListConverter @Inject constructor(
    @ListItemConverter
    private val itemConverter: Converter<DrinkDto, DrinkModel>,
) : Converter<ResponseBodyDto<DrinkDto>, @JvmSuppressWildcards List<DrinkModel>> {

    override fun convert(input: ResponseBodyDto<DrinkDto>): List<DrinkModel> {
        if (!input.drinks.isNullOrEmpty()) {
            return input.drinks
                .map { drinkDto -> itemConverter.convert(drinkDto) }
                .filter { drinkModel -> drinkModel.id.isNotBlank() && drinkModel.name.isNotBlank() }
        }

        return emptyList()
    }
}
