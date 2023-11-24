package com.pereyrarg11.drinks.core.presentation

import androidx.lifecycle.ViewModel
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.data.util.MissingParamsException
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.core.util.error.ErrorLogger

abstract class BaseViewModel constructor(
    private val errorLogger: ErrorLogger,
) : ViewModel() {

    protected abstract fun handleError(exception: Exception?)

    protected fun getErrorMessage(exception: Exception?): UiText {
        return when (exception) {
            is MissingParamsException -> UiText.StringResource(R.string.error_missing_query_params)
            else -> UiText.StringResource(R.string.error_default)
        }
    }

    fun logException(exception: Exception) {
        errorLogger.logException(exception)
    }
}
