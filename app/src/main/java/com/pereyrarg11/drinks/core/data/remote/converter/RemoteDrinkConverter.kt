package com.pereyrarg11.drinks.core.data.remote.converter

import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkConverter @Inject constructor() : Converter<DrinkDto, DrinkModel> {

    override fun convert(input: DrinkDto): DrinkModel {
        return DrinkModel(
            id = input.idDrink.orEmpty(),
            name = input.strDrink.orEmpty(),
            imageUrl = input.strDrinkThumb.orEmpty(),
        )
    }
}
