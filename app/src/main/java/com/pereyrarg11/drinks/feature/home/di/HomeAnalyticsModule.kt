package com.pereyrarg11.drinks.feature.home.di

import com.pereyrarg11.drinks.feature.home.analytics.HomeAnalyticsLogger
import com.pereyrarg11.drinks.feature.home.analytics.HomeAnalyticsLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeAnalyticsModule {
    @Binds
    abstract fun bindHomeAnalyticsLogger(
        homeAnalyticsLogger: HomeAnalyticsLoggerImpl
    ): HomeAnalyticsLogger
}
