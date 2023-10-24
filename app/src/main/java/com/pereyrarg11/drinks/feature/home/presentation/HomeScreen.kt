package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.unit.dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.ScreenSlot
import com.pereyrarg11.drinks.feature.home.domain.HomeUtils
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType.ALCOHOL
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType.CATEGORIES
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType.INGREDIENTS
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType.UNKNOWN
import com.pereyrarg11.drinks.feature.home.presentation.components.CircleRow
import com.pereyrarg11.drinks.feature.home.presentation.components.HeroRow
import com.pereyrarg11.drinks.feature.home.presentation.components.HorizontalGrid

private val sections = listOf(
    HomeSectionModel(
        "",
        HomeUtils.getPreviewItems(),
        type = ALCOHOL,
    ),
    HomeSectionModel(
        "Categories",
        HomeUtils.getPreviewItems(),
        type = CATEGORIES,
    ),
    HomeSectionModel(
        label = "Ingredients",
        filters = HomeUtils.getPreviewItems().filter { it.type.equals(INGREDIENTS) },
        type = INGREDIENTS,
    ),
)

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    val verticalSlotPadding = dimensionResource(id = R.dimen.size_lg)

    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        sections.forEachIndexed { index, section ->
            ScreenSlot(
                label = section.label,
                modifier = Modifier.padding(
                    bottom = verticalSlotPadding,
                    top = if (index == 0) verticalSlotPadding else 0.dp
                )
            ) {
                when (section.type) {
                    ALCOHOL -> HeroRow(models = section.filters)
                    CATEGORIES -> HorizontalGrid(models = section.filters)
                    INGREDIENTS -> CircleRow(models = section.filters)
                    UNKNOWN -> {
                        // TODO: this case could be recorded by Crashlytics/Error logger
                    }
                }
            }
        }
    }
}