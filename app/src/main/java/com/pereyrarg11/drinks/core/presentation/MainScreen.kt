package com.pereyrarg11.drinks.core.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    content: @Composable (Modifier) -> Unit = {},
) {
    Scaffold(modifier = modifier) {
        content(Modifier.padding(it))
    }
}