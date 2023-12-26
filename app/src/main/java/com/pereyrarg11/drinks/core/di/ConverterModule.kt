package com.pereyrarg11.drinks.core.di

import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkDetailConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkDetailListConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkIngredientConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkIngredientListConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkListConverter
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkIngredientDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkIngredientModel
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.presentation.converter.UiDrinkConverter
import com.pereyrarg11.drinks.core.presentation.converter.UiDrinkDetailConverter
import com.pereyrarg11.drinks.core.presentation.converter.UiDrinkListConverter
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkUiDetail
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ConverterModule {
    @Binds
    @EntitySummaryConverter
    abstract fun bindRemoteDrinkConverter(
        converter: RemoteDrinkConverter,
    ): Converter<DrinkDto, DrinkModel>

    @Binds
    @EntitySummaryConverter
    abstract fun bindRemoteDrinkListConverter(
        converter: RemoteDrinkListConverter,
    ): Converter<ResponseBodyDto<DrinkDto>, List<DrinkModel>>

    @Binds
    @EntityDetailConverter
    abstract fun bindRemoteDrinkDetailConverter(
        converter: RemoteDrinkDetailConverter,
    ): Converter<DrinkDto, DrinkModel>

    @Binds
    @EntityDetailConverter
    abstract fun bindRemoteDrinkDetailListConverter(
        converter: RemoteDrinkDetailListConverter,
    ): Converter<ResponseBodyDto<DrinkDto>, List<DrinkModel>>

    @Binds
    @EntitySummaryConverter
    abstract fun bindUiDrinkConverter(
        converter: UiDrinkConverter,
    ): Converter<DrinkModel, DrinkUiItem>

    @Binds
    @EntitySummaryConverter
    abstract fun bindUiDrinkListConverter(
        converter: UiDrinkListConverter,
    ): Converter<List<DrinkModel>, List<DrinkUiItem>>

    @Binds
    @EntityDetailConverter
    abstract fun bindUiDrinkDetailConverter(
        converter: UiDrinkDetailConverter,
    ): Converter<DrinkModel, DrinkUiDetail>

    @Binds
    abstract fun bindRemoteDrinkIngredientConverter(
        converter: RemoteDrinkIngredientConverter,
    ): Converter<DrinkIngredientDto, DrinkIngredientModel>

    @Binds
    abstract fun bindRemoteDrinkIngredientListConverter(
        converter: RemoteDrinkIngredientListConverter,
    ): Converter<List<DrinkIngredientDto>, List<DrinkIngredientModel>>
}
