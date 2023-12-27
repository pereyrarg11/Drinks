package com.pereyrarg11.drinks.feature.filter.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.UiConstants
import com.pereyrarg11.drinks.core.presentation.components.HeroCard
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.StaticDisplayableProvider

@Composable
fun FilterContent(
    drinks: List<DrinkUiItem>,
    modifier: Modifier = Modifier,
    onClickDrink: (DrinkUiItem) -> Unit = {},
) {
    val columns = 2
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val padding = dimensionResource(id = R.dimen.size_sm)
    val cardWidth =
        screenWidth - padding.times(2/*left and right*/) - padding.times(columns - 1 /*between columns*/)
    val cardHeight = cardWidth / UiConstants.RATIO_4_TO_3

    LazyVerticalGrid(
        columns = GridCells.Fixed(columns),
        modifier = modifier,
        contentPadding = PaddingValues(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        horizontalArrangement = Arrangement.spacedBy(padding),
    ) {
        items(drinks) { drink ->
            HeroCard(
                label = drink.label,
                imageUrl = drink.imageUrl,
                modifier = Modifier.height(cardHeight),
            ) {
                onClickDrink(drink)
            }
        }
    }
}

@Preview
@Composable
fun FilterContentPreview() {
    DrinksTheme {
        FilterContent(
            drinks = StaticDisplayableProvider.getDrinks()
        )
    }
}
