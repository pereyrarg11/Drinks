package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    MainScreen(
        modifier = modifier,
    ) {
        val state = viewModel.state

        when {
            state.hasError -> ErrorScreen(message = state.errorMessage.asString())
            !state.isLoading && !state.hasError -> HomeSuccessScreen(sections = state.sections)
            else -> LoadingScreen()
        }
    }
}