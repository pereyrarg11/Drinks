package com.pereyrarg11.drinks.feature.drink.di

import com.pereyrarg11.drinks.feature.drink.data.remote.DrinkDetailApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DrinkApiModule {
    @Provides
    @Singleton
    fun provideDrinkApi(retrofit: Retrofit): DrinkDetailApi {
        return retrofit.create(DrinkDetailApi::class.java)
    }
}
