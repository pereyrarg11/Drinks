package com.pereyrarg11.drinks.core.di

import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkListConverter
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.ResponseBodyDto
import com.pereyrarg11.drinks.core.data.util.Converter
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
    @Binds
    @ListItemConverter
    abstract fun bindRemoteDrinkConverter(
        converter: RemoteDrinkConverter,
    ): Converter<DrinkDto, DrinkModel>

    @Binds
    abstract fun bindRemoteDrinkListConverter(
        converter: RemoteDrinkListConverter,
    ): Converter<ResponseBodyDto<DrinkDto>, List<DrinkModel>>

    @Binds
    abstract fun bindUiDrinkConverter(
        converter: UiDrinkConverter,
    ): Converter<DrinkModel, DrinkDisplayable>

    @Binds
    abstract fun bindUiDrinkListConverter(
        converter: UiDrinkListConverter,
    ): Converter<List<DrinkModel>, List<DrinkDisplayable>>
}
