package com.pereyrarg11.drinks.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EntityDetailConverter

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EntitySummaryConverter
