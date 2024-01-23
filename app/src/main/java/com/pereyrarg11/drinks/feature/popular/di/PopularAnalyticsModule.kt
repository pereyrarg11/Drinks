package com.pereyrarg11.drinks.feature.popular.di

import com.pereyrarg11.drinks.feature.popular.analytics.PopularAnalyticsLogger
import com.pereyrarg11.drinks.feature.popular.analytics.PopularAnalyticsLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class PopularAnalyticsModule {
    @Binds
    @ViewModelScoped
    abstract fun bindPopularAnalyticsLogger(
        logger: PopularAnalyticsLoggerImpl
    ): PopularAnalyticsLogger
}
