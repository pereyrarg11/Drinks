package com.pereyrarg11.drinks.feature.drink.di

import com.pereyrarg11.drinks.feature.drink.data.repository.DrinkDetailRepositoryImpl
import com.pereyrarg11.drinks.feature.drink.domain.repository.DrinkDetailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DrinkDataModule {
    @Binds
    @Singleton
    abstract fun bindFilterRepository(
        repository: DrinkDetailRepositoryImpl,
    ): DrinkDetailRepository
}
