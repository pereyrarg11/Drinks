package com.pereyrarg11.drinks.feature.drink.di

import com.pereyrarg11.drinks.feature.drink.analytics.DrinkAnalyticsLogger
import com.pereyrarg11.drinks.feature.drink.analytics.DrinkAnalyticsLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DrinkAnalyticsModule {
    @Binds
    abstract fun bindDrinkAnalyticsLogger(
        drinkAnalyticsLoggerImpl: DrinkAnalyticsLoggerImpl
    ): DrinkAnalyticsLogger
}
