package com.pereyrarg11.drinks.feature.popular.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen
import com.pereyrarg11.drinks.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.drinks.feature.popular.presentation.components.PopularContent
import com.pereyrarg11.drinks.feature.popular.presentation.model.PopularUiEvent

@Composable
fun PopularScreen(
    onNavigate: (String) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: PopularViewModel = hiltViewModel(),
) {
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is PopularUiEvent.NavigateToDrinkDetail -> onNavigate(
                    ScreenRoute.Drink.createRoute(event.drinkId)
                )
            }
        }
    }

    val uiState = viewModel.uiState

    MainScreen(modifier) { contentModifier ->
        when {
            uiState.hasError -> ErrorScreen(
                message = uiState.errorMessage,
                modifier = contentModifier
            )

            !uiState.hasError && !uiState.isLoading -> PopularContent(
                drinks = uiState.drinks,
                modifier = contentModifier,
                onClickDrink = {
                    viewModel.onClickDrink(it)
                },
                onDisplayDrink = {
                    viewModel.onDisplayDrink(it)
                }
            )

            else -> LoadingScreen(modifier = contentModifier)
        }
    }
}
