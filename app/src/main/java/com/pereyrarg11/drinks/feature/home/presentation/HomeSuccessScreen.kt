package com.pereyrarg11.drinks.feature.home.presentation

import android.util.Log
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
import com.pereyrarg11.drinks.feature.home.domain.HomeUtils
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionType
import com.pereyrarg11.drinks.feature.home.presentation.components.CircleRow
import com.pereyrarg11.drinks.feature.home.presentation.components.HeroRow
import com.pereyrarg11.drinks.feature.home.presentation.components.HorizontalGrid

private fun handleNavigation(model: HomeFilterModel) {
    Log.i("HomeSuccessScreen", "label:${model.label} query:${model.type.queryParam}=${model.queryValue}")
}

@Composable
fun HomeSuccessScreen(
    sections: List<HomeSectionModel>,
    modifier: Modifier = Modifier,
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
                        handleNavigation(model)
                    }

                    HomeSectionType.CATEGORIES -> HorizontalGrid(models = section.filters) { model ->
                        handleNavigation(model)
                    }

                    HomeSectionType.INGREDIENTS -> CircleRow(models = section.filters) { model ->
                        handleNavigation(model)
                    }

                    HomeSectionType.UNKNOWN -> {
                        // TODO: this case could be recorded by Crashlytics/Error logger
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeSuccessScreenPreview() {
    DrinksTheme {
        HomeSuccessScreen(sections = HomeUtils.getDefaultSections())
    }
}