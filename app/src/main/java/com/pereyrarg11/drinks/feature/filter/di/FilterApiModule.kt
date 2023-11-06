package com.pereyrarg11.drinks.feature.filter.di

import com.pereyrarg11.drinks.feature.filter.data.remote.FilterApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object FilterApiModule {
    @Provides
    @Singleton
    fun provideFilterApi(retrofit: Retrofit): FilterApi {
        return retrofit.create(FilterApi::class.java)
    }
}
