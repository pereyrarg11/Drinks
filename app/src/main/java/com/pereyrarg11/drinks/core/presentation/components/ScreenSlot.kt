package com.pereyrarg11.drinks.core.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.home.domain.HomeUtils
import com.pereyrarg11.drinks.feature.home.presentation.components.HeroRow

@Composable
fun ScreenSlot(
    label: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Column(modifier = modifier) {
        if (label.isNotBlank()) {
            Text(
                text = label,
                modifier = Modifier
                    .padding(horizontal = dimensionResource(id = R.dimen.size_md))
                    .paddingFromBaseline(
                        top = dimensionResource(id = R.dimen.size_xxl),
                        bottom = dimensionResource(id = R.dimen.size_md)
                    ),
                style = MaterialTheme.typography.headlineLarge
            )
        }

        content()
    }
}

@Preview
@Composable
fun ScreenSlotPreview() {
    DrinksTheme {
        ScreenSlot(
            label = "Filters"
        ) {
            HeroRow(
                models = HomeUtils.getDefaultFilters(),
            )
        }
    }
}