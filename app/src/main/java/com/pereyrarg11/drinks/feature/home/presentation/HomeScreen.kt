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
import com.pereyrarg11.drinks.feature.home.presentation.components.HeroRow

private val sections = listOf(
    HomeSectionModel(
        "",
        HomeUtils.getPreviewItems()
    ),
    HomeSectionModel(
        "Categories",
        HomeUtils.getPreviewItems()
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
                HeroRow(models = section.filters)
            }
        }
    }
}