package com.pereyrarg11.drinks.feature.drink.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.presentation.ErrorScreen
import com.pereyrarg11.drinks.core.presentation.LoadingScreen
import com.pereyrarg11.drinks.core.presentation.MainScreen
import com.pereyrarg11.drinks.core.presentation.components.DetailAppBar
import com.pereyrarg11.drinks.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.drinks.feature.drink.presentation.components.DrinkSuccessScreen
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkTagType

@Composable
fun DrinkScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: DrinkViewModel = hiltViewModel(),
) {
    val uiState = viewModel.uiState

    MainScreen(
        modifier = modifier,
        topBar = {
            DetailAppBar(title = uiState.title) {
                navController.popBackStack()
            }
        }
    ) { contentModifier ->
        when {
            uiState.hasError -> ErrorScreen(
                message = uiState.errorMessage,
                modifier = contentModifier
            )

            !uiState.isLoading && !uiState.hasError -> DrinkSuccessScreen(
                drink = uiState.drink,
                modifier = contentModifier
            ) { tag ->
                val filterType = when (tag.type) {
                    DrinkTagType.ALCOHOL -> FilterType.ALCOHOL
                    DrinkTagType.CATEGORY -> FilterType.CATEGORY
                    DrinkTagType.UNKNOWN -> return@DrinkSuccessScreen
                }
                // navigate to FilterScreen
                navController.navigate(
                    route = ScreenRoute.Filter.createRoute(filterType.param, tag.query),
                    // avoid circular navigation
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(ScreenRoute.Home.route, inclusive = false)
                        .build()
                )
            }

            else -> LoadingScreen(modifier = contentModifier)
        }
    }
}
