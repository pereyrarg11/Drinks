package com.pereyrarg11.drinks.core.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkListDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkListConverter @Inject constructor(
    private val itemConverter: Converter<DrinkDto, DrinkModel>,
) : Converter<DrinkListDto, @JvmSuppressWildcards List<DrinkModel>> {
    override fun convert(input: DrinkListDto): List<DrinkModel> {
        if (input.drinks != null) {
            return input.drinks
                .map { dto -> itemConverter.convert(dto) }
                .filter { model -> model.id.isNotBlank() && model.name.isNotBlank() }
        }

        return emptyList()
    }
}
