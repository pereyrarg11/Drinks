package com.pereyrarg11.drinks.feature.popular.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pereyrarg11.drinks.core.presentation.components.HeroCard
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PopularContent(
    drinks: List<DrinkUiItem>,
    onClickDrink: (DrinkUiItem) -> Unit,
    onDisplayDrink: (DrinkUiItem) -> Unit,
    modifier: Modifier = Modifier,
) {
    val pagerState = rememberPagerState(initialPage = 1) {
        drinks.size
    }

    LaunchedEffect(key1 = pagerState) {
        snapshotFlow { pagerState.settledPage }.collect { page ->
            onDisplayDrink(drinks[page])
        }
    }

    HorizontalPager(
        state = pagerState,
        modifier = modifier,
        pageSpacing = 20.dp,
        contentPadding = PaddingValues(horizontal = 50.dp),
    ) { page ->
        val drink = drinks[page]
        HeroCard(
            label = drink.label,
            imageUrl = drink.imageUrl,
            modifier = Modifier.fillMaxWidth(),
            onClickListener = { onClickDrink(drink) }
        )
    }
}

@Preview
@Composable
fun PopularContentPreview() {
    DrinksTheme {
        PopularContent(drinks = emptyList(), onClickDrink = {}, onDisplayDrink = {})
    }
}
