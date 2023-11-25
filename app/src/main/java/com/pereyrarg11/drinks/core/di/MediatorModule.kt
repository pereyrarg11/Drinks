package com.pereyrarg11.drinks.core.di

import com.pereyrarg11.drinks.core.logger.error.ErrorLogger
import com.pereyrarg11.drinks.core.logger.error.ErrorLoggerMediator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MediatorModule {
    @Binds
    abstract fun bindErrorLoggerMediator(errorLogger: ErrorLoggerMediator): ErrorLogger
}
