package com.pereyrarg11.drinks.feature.filter.di

import com.pereyrarg11.drinks.feature.filter.data.repository.FilterRepositoryImpl
import com.pereyrarg11.drinks.feature.filter.domain.repository.FilterRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FilterDataModule {
    @Binds
    @Singleton
    abstract fun bindFilterRepository(
        repository: FilterRepositoryImpl,
    ): FilterRepository
}
