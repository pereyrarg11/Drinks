package com.pereyrarg11.drinks.core.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.data.util.MissingQueryParamsException
import com.pereyrarg11.drinks.core.presentation.util.UiText

abstract class BaseViewModel : ViewModel() {
    private val tag = this.javaClass.simpleName

    protected abstract fun handleError(exception: Exception?)

    protected fun getErrorMessage(exception: Exception?): UiText {
        return when (exception) {
            is MissingQueryParamsException -> UiText.StringResource(R.string.error_missing_query_params)
            else -> UiText.StringResource(R.string.error_default)
        }
    }

    protected fun logException(exception: Exception) {
        Log.e(tag, exception.message.orEmpty(), exception)
    }
}
