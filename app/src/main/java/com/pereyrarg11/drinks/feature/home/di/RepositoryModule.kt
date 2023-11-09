package com.pereyrarg11.drinks.feature.home.di

import com.pereyrarg11.drinks.feature.home.data.repository.HomeRepositoryImpl
import com.pereyrarg11.drinks.feature.home.domain.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindHomeRepository(
        repositoryImpl: HomeRepositoryImpl,
    ): HomeRepository
}