package com.pereyrarg11.drinks.feature.filter.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen

@Composable
fun FilterScreen(
    modifier: Modifier = Modifier,
    viewModel: FilterViewModel = hiltViewModel(),
) {
    MainScreen(
        modifier = modifier,
    ) {
        val state = viewModel.state

        when {
            state.hasError -> ErrorScreen(message = state.errorMessage)
            !state.isLoading && !state.hasError -> FilterSuccessScreen(drinks = state.drinks)
            else -> LoadingScreen()
        }
    }
}
