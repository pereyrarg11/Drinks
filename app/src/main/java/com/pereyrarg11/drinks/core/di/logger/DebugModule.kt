package com.pereyrarg11.drinks.core.di.logger

import com.pereyrarg11.drinks.core.logger.debug.CrashlyticsDebugLoggerFacade
import com.pereyrarg11.drinks.core.logger.debug.DebugLogger
import com.pereyrarg11.drinks.core.logger.debug.DebugLoggerMediator
import com.pereyrarg11.drinks.core.logger.debug.LogcatDebugLoggerFacade
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class DebugModule {
    @Binds
    @IntoSet
    abstract fun bindLogcatDebugLoggerFacade(
        debugLoggerFacade: LogcatDebugLoggerFacade
    ): DebugLogger.Facade

    @Binds
    @IntoSet
    abstract fun bindCrashlyticsDebugLoggerFacade(
        debugLoggerFacade: CrashlyticsDebugLoggerFacade
    ): DebugLogger.Facade

    @Binds
    abstract fun bindDebugLogger(
        debugLogger: DebugLoggerMediator
    ): DebugLogger
}
