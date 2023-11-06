package com.pereyrarg11.drinks.feature.filter.di

import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkConverter
import com.pereyrarg11.drinks.core.data.remote.converter.RemoteDrinkListConverter
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkDto
import com.pereyrarg11.drinks.core.data.remote.dto.DrinkListDto
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FilterConverterModule {
    @Binds
    abstract fun bindRemoteDrinkConverter(
        converter: RemoteDrinkConverter,
    ): Converter<DrinkDto, DrinkModel>

    @Binds
    abstract fun bindRemoteDrinkListConverter(
        converter: RemoteDrinkListConverter,
    ): Converter<DrinkListDto, List<DrinkModel>>
}
