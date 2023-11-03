package com.pereyrarg11.drinks.core.domain.util

sealed interface DataResult<T> {
    data class Success<T>(
        val data: T,
    ) : DataResult<T>

    data class Error<T>(
        val exception: Exception? = null,
        val data: T? = null,
    ) : DataResult<T>

    data class Loading<T>(
        val isLoading: Boolean = false,
    ) : DataResult<T>
}