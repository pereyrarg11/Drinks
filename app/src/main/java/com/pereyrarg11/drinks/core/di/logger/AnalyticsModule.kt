package com.pereyrarg11.drinks.core.di.logger

import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.AnalyticsLoggerMediator
import com.pereyrarg11.drinks.core.logger.analytics.DebugAnalyticsLogger
import com.pereyrarg11.drinks.core.logger.analytics.FirebaseAnalyticsLogger
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AnalyticsModule {
    @Binds
    @IntoSet
    abstract fun bindFirebaseAnalyticsLogger(
        analyticsLogger: FirebaseAnalyticsLogger
    ): AnalyticsLogger.Facade

    @Binds
    @IntoSet
    abstract fun bindDebugAnalyticsLogger(
        analyticsLogger: DebugAnalyticsLogger
    ): AnalyticsLogger.Facade

    @Binds
    abstract fun bindAnalyticsLogger(
        analyticsLogger: AnalyticsLoggerMediator
    ): AnalyticsLogger
}
