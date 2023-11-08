package com.pereyrarg11.drinks.feature.drink.di

import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.feature.drink.data.remote.converter.RemoteDrinkDetailConverter
import com.pereyrarg11.drinks.feature.drink.data.remote.converter.RemoteDrinkIngredientConverter
import com.pereyrarg11.drinks.feature.drink.data.remote.converter.RemoteDrinkIngredientListConverter
import com.pereyrarg11.drinks.feature.drink.data.remote.converter.RemoteDrinkMediaConverter
import com.pereyrarg11.drinks.feature.drink.data.remote.converter.ResponseDrinkDetailConverter
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkDetailDto
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.feature.drink.data.remote.dto.DrinkMediaDto
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkIngredientModel
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkMediaModel
import com.pereyrarg11.drinks.feature.drink.presentation.converter.UiDrinkDetailConverter
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkDetailDisplayable
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DrinkConverterModule {
    /* Remote data converters */
    @Binds
    abstract fun bindRemoteDrinkIngredientConverter(
        converter: RemoteDrinkIngredientConverter,
    ): Converter<DrinkIngredientDto, DrinkIngredientModel>

    @Binds
    abstract fun bindRemoteDrinkIngredientListConverter(
        converter: RemoteDrinkIngredientListConverter,
    ): Converter<List<DrinkIngredientDto>, List<DrinkIngredientModel>>

    @Binds
    abstract fun bindRemoteDrinkMediaConverter(
        converter: RemoteDrinkMediaConverter,
    ): Converter<DrinkMediaDto, DrinkMediaModel>

    @Binds
    abstract fun bindRemoteDrinkDetailConverter(
        converter: RemoteDrinkDetailConverter,
    ): Converter<DrinkDetailDto, DrinkDetailModel>

    @Binds
    abstract fun bindResponseDrinkDetailConverter(
        converter: ResponseDrinkDetailConverter,
    ): Converter<ResponseBodyDto<DrinkDetailDto>, List<DrinkDetailModel>>

    /* UI converters */
    @Binds
    abstract fun bindUiDrinkDetailConverter(
        converter: UiDrinkDetailConverter,
    ): Converter<DrinkDetailModel, DrinkDetailDisplayable>
}
