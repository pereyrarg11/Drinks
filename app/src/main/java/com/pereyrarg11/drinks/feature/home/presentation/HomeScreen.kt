package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen
import com.pereyrarg11.drinks.core.presentation.navigation.ScreenRoute

@Composable
fun HomeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    MainScreen(
        modifier = modifier,
    ) {
        val state = viewModel.state

        when {
            state.hasError -> ErrorScreen(message = state.errorMessage)
            !state.isLoading && !state.hasError -> HomeSuccessScreen(sections = state.sections) { model ->
                navController.navigate(
                    ScreenRoute.Filter.createRoute(
                        model.type.param,
                        model.query
                    )
                )
            }

            else -> LoadingScreen()
        }
    }
}