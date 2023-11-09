package com.pereyrarg11.drinks.core.presentation.util

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {

    data class PlainText(val value: String) : UiText()

    class StringResource(
        @StringRes val id: Int,
        val args: Array<Any> = emptyArray(),
    ) : UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is PlainText -> value
            is StringResource -> stringResource(id, args)
        }
    }
}
