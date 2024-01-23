package com.pereyrarg11.drinks.feature.popular.di

import com.pereyrarg11.drinks.feature.popular.data.repository.PopularRepositoryImpl
import com.pereyrarg11.drinks.feature.popular.domain.repository.PopularRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class PopularDataModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPopularRepository(repository: PopularRepositoryImpl): PopularRepository
}
