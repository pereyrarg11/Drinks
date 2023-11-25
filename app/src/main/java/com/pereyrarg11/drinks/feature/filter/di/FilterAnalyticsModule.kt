package com.pereyrarg11.drinks.feature.filter.di

import com.pereyrarg11.drinks.feature.filter.analytics.FilterAnalyticsLogger
import com.pereyrarg11.drinks.feature.filter.analytics.FilterAnalyticsLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class FilterAnalyticsModule {
    @Binds
    abstract fun bindFilterAnalyticsLogger(
        filterAnalyticsLogger: FilterAnalyticsLoggerImpl
    ): FilterAnalyticsLogger
}
