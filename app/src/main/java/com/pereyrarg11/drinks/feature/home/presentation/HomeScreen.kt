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
import com.pereyrarg11.drinks.feature.home.domain.model.HomeFilterModel
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel
import com.pereyrarg11.drinks.feature.home.presentation.components.HeroRow

private val sections = listOf(
    HomeSectionModel(
        "",
        listOf(
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
        )
    ),
    HomeSectionModel(
        "Categories",
        listOf(
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