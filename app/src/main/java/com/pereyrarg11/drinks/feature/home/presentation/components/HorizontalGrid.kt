package com.pereyrarg11.drinks.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.HorizontalCard
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel

@Composable
fun HorizontalGrid(
    models: List<HomeFilterModel>,
    modifier: Modifier = Modifier,
    maxRows: Int = integerResource(id = R.integer.horizontal_grid_rows),
    onClickListener: (HomeFilterModel) -> Unit = {},
) {
    val padding = dimensionResource(id = R.dimen.size_md)
    val cardHeight = dimensionResource(id = R.dimen.horizontal_card_height)
    val cardWidth = dimensionResource(id = R.dimen.horizontal_card_width)

    LazyHorizontalGrid(
        rows = GridCells.Fixed(maxRows),
        modifier = modifier.height(cardHeight.times(maxRows) + padding.times(maxRows - 1)),
        horizontalArrangement = Arrangement.spacedBy(padding),
        verticalArrangement = Arrangement.spacedBy(padding),
        contentPadding = PaddingValues(horizontal = padding),
    ) {
        items(models) { model ->
            HorizontalCard(
                label = model.label,
                imageUrl = model.imageUrl,
                modifier = Modifier
                    .width(cardWidth)
                    .height(cardHeight)
            ) {
                onClickListener(model)
            }
        }
    }
}

@Preview
@Composable
fun HorizontalGridPreview() {
    DrinksTheme {
        HorizontalGrid(
            models = listOf(
                HomeFilterModel(
                    "Alcoholic",
                    "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg"
                ),
                HomeFilterModel(
                    "Non Alcoholic",
                    "https://www.thecocktaildb.com/images/media/drink/xwqvur1468876473.jpg"
                ),
                HomeFilterModel(
                    "Optional",
                    "https://www.thecocktaildb.com/images/media/drink/vuxwvt1468875418.jpg"
                ),
                HomeFilterModel(
                    "Cocktail",
                    "https://www.thecocktaildb.com/images/media/drink/rptuxy1472669372.jpg"
                ),
                HomeFilterModel(
                    "Shake",
                    "https://www.thecocktaildb.com/images/media/drink/uvypss1472720581.jpg"
                ),
                HomeFilterModel(
                    "Shot",
                    "https://www.thecocktaildb.com/images/media/drink/rtpxqw1468877562.jpg"
                ),
                HomeFilterModel(
                    "Beer",
                    "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg"
                ),
                HomeFilterModel(
                    "Coffee / Tea",
                    "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg"
                ),
            )
        )
    }
}