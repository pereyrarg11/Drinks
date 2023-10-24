package com.pereyrarg11.drinks.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel

@Composable
fun HeroRow(
    models: List<HomeFilterModel>,
    modifier: Modifier = Modifier,
    onClickListener: (HomeFilterModel) -> Unit = {},
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_sm)),
        contentPadding = PaddingValues(horizontal = dimensionResource(id = R.dimen.size_md)),
    ) {
        items(models) { model ->
            HeroCard(
                label = model.label,
                imageUrl = model.imageUrl,
                modifier = Modifier
                    .width(dimensionResource(id = R.dimen.hero_card_width))
                    .height(dimensionResource(id = R.dimen.hero_card_height)),
                onClickListener = { onClickListener(model) },
            )
        }
    }
}

@Preview
@Composable
fun HeroRowPreview() {
    DrinksTheme {
        HeroRow(
            models = listOf(
                HomeFilterModel(
                    "Alcoholic",
                    "https://www.thecocktaildb.com/images/media/drink/xxyywq1454511117.jpg"
                ),
                HomeFilterModel(
                    "Beer",
                    "https://www.thecocktaildb.com/images/media/drink/rwpswp1454511017.jpg"
                ),
                HomeFilterModel(
                    "Coffee",
                    "https://www.thecocktaildb.com/images/media/drink/vqwptt1441247711.jpg"
                ),
                HomeFilterModel(
                    "Ron",
                    "https://www.thecocktaildb.com/images/media/drink/i9suxb1582474926.jpg"
                ),
                HomeFilterModel(
                    "Non alcoholic",
                    "https://www.thecocktaildb.com/images/media/drink/qyqtpv1468876144.jpg"
                ),
            )
        )
    }
}
