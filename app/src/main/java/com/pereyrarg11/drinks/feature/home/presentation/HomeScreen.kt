package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pereyrarg11.drinks.core.presentation.MainScreen
import com.pereyrarg11.drinks.feature.home.domain.HomeUtils

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    MainScreen(
        modifier = modifier,
    ) {
        HomeSuccessScreen(
            sections = HomeUtils.getDefaultSections(),
        )
    }
}