package com.pereyrarg11.drinks.feature.filter.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen
import com.pereyrarg11.drinks.core.presentation.components.DetailAppBar
import com.pereyrarg11.drinks.core.presentation.util.UiText

@Composable
fun FilterScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: FilterViewModel = hiltViewModel(),
) {
    // TODO: get screen title from query param
    MainScreen(
        modifier = modifier,
        topBar = {
            DetailAppBar(title = UiText.PlainText("Drinks")) {
                navController.popBackStack()
            }
        }
    ) { contentModifier ->
        val state = viewModel.state

        when {
            state.hasError -> ErrorScreen(message = state.errorMessage, modifier = contentModifier)
            !state.isLoading && !state.hasError -> FilterSuccessScreen(
                drinks = state.drinks,
                modifier = contentModifier
            )

            else -> LoadingScreen(modifier = contentModifier)
        }
    }
}
