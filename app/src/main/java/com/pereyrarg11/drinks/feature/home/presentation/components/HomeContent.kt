package com.pereyrarg11.drinks.feature.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.ScreenSlot
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.home.data.repository.StaticHomeProvider
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType

@Composable
fun HomeContent(
    sections: List<HomeSectionModel>,
    modifier: Modifier = Modifier,
    onClickFilter: (HomeFilterModel) -> Unit = {},
    onError: (Exception) -> Unit = {},
) {
    val verticalSlotPadding = dimensionResource(id = R.dimen.size_lg)

    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        sections.forEachIndexed { index, section ->
            ScreenSlot(
                label = section.label,
                modifier = Modifier.padding(
                    bottom = verticalSlotPadding,
                    top = if (index == 0) verticalSlotPadding else 0.dp
                )
            ) {
                when (section.type) {
                    HomeSectionType.ALCOHOL -> HeroRow(models = section.filters) { model ->
                        // TODO: create a HomeFilterDisplayable, then use it instead of HomeFilterModel
                        onClickFilter(model)
                    }

                    HomeSectionType.CATEGORIES -> HorizontalGrid(models = section.filters) { model ->
                        onClickFilter(model)
                    }

                    HomeSectionType.INGREDIENTS -> CircleRow(models = section.filters) { model ->
                        onClickFilter(model)
                    }

                    HomeSectionType.UNKNOWN -> {
                        onError(Exception("HomeSectionType.UNKNOWN case reached."))
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeContentPreview() {
    DrinksTheme {
        HomeContent(sections = StaticHomeProvider.getAllSections())
    }
}
