package com.pereyrarg11.drinks.core.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class EntityConverter

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ListItemConverter
