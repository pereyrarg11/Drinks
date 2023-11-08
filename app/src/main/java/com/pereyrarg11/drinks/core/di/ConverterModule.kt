package com.pereyrarg11.drinks.core.di

import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkIngredientConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkIngredientListConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkListConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkMediaConverter
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkListDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkMediaDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkIngredientModel
import com.pereyrarg11.drinks.core.domain.model.DrinkMediaModel
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.converter.UiDrinkConverter
import com.pereyrarg11.drinks.core.presentation.converter.UiDrinkListConverter
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ConverterModule {
    /* Remote converters */
    @Binds
    abstract fun bindRemoteDrinkConverter(
        converter: RemoteDrinkConverter,
    ): Converter<DrinkDto, DrinkModel>

    @Binds
    abstract fun bindRemoteDrinkListConverter(
        converter: RemoteDrinkListConverter,
    ): Converter<DrinkListDto, List<DrinkModel>>

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

    /* UI converters */
    @Binds
    abstract fun bindUiDrinkConverter(
        converter: UiDrinkConverter,
    ): Converter<DrinkModel, DrinkDisplayable>

    @Binds
    abstract fun bindUiDrinkListConverter(
        converter: UiDrinkListConverter,
    ): Converter<List<DrinkModel>, List<DrinkDisplayable>>
}
