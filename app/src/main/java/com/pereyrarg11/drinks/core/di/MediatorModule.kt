package com.pereyrarg11.drinks.core.di

import com.pereyrarg11.drinks.core.util.error.ErrorLogger
import com.pereyrarg11.drinks.core.util.error.ErrorLoggerMediator
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class MediatorModule {
    @Binds
    abstract fun bind(errorLogger: ErrorLoggerMediator): ErrorLogger
}
