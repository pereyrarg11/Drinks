package com.pereyrarg11.drinks.feature.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.CircleCard
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.home.domain.HomeUtils
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel

@Composable
fun CircleRow(
    models: List<HomeFilterModel>,
    modifier: Modifier = Modifier,
    onClickListener: (HomeFilterModel) -> Unit = {},
) {
    val cardPadding = dimensionResource(id = R.dimen.size_md)

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(cardPadding),
        contentPadding = PaddingValues(horizontal = cardPadding),
    ) {
        items(models) { model ->
            CircleCard(
                label = model.label,
                imageUrl = model.imageUrl
            ) {
                onClickListener(model)
            }
        }
    }
}

@Preview
@Composable
fun CircleRowPreview() {
    DrinksTheme {
        CircleRow(models = HomeUtils.getPreviewItems())
    }
}