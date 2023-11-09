package com.pereyrarg11.drinks.core.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    message: UiText = UiText.StringResource(R.string.error_default),
) {
    FeedbackScreen(
        message = message,
        imageVector = Icons.Default.Build,
        modifier = modifier,
    )
}

@Preview
@Composable
fun ErrorScreenPreview() {
    DrinksTheme {
        ErrorScreen()
    }
}
