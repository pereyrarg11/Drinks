package com.pereyrarg11.drinks.feature.splash.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.pereyrarg11.drinks.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.drinks.feature.splash.presentation.component.SplashContent
import com.pereyrarg11.drinks.feature.splash.presentation.model.SplashUiEvent

@Composable
fun SplashScreen(
    onNavigate: (ScreenRoute) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                SplashUiEvent.NavigateToHome -> onNavigate(ScreenRoute.Home)
            }
        }
    }

    SplashContent(modifier = modifier)
}
