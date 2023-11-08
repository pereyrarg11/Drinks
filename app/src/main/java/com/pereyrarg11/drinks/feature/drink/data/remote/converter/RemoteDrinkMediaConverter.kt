package com.pereyrarg11.drinks.feature.drink.data.remote.converter

import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkMediaDto
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkMediaModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDrinkMediaConverter @Inject constructor() : Converter<DrinkMediaDto, DrinkMediaModel> {
    override fun convert(input: DrinkMediaDto): DrinkMediaModel {
        return DrinkMediaModel(
            thumbUrl = input.strDrinkThumb.orEmpty(),
            imageUrl = input.strImageSource.orEmpty(),
            videoUrl = input.strVideo.orEmpty(),
            attribution = input.strImageAttribution.orEmpty()
        )
    }
}
