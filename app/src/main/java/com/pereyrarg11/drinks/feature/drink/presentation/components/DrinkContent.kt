package com.pereyrarg11.drinks.feature.drink.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.DefaultImage
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkUiDetail
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkTagType
import com.pereyrarg11.drinks.feature.drink.presentation.model.TagUiItem

@Composable
fun DrinkContent(
    drink: DrinkUiDetail,
    modifier: Modifier = Modifier,
    onClickTag: (TagUiItem) -> Unit = {},
) {
    val innerPadding = dimensionResource(id = R.dimen.size_md)

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
    ) {
        ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
            DefaultImage(
                url = drink.mediaUrl,
                contentDescription = drink.title.asString(),
                modifier = Modifier.aspectRatio(1f),
            )
        }
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text(
                text = drink.title.asString(),
                style = MaterialTheme.typography.headlineLarge,
            )

            /* Tags */
            if (drink.tags.isNotEmpty()) {
                TagRow(tags = drink.tags) {
                    onClickTag(it)
                }
            }

            /* Ingredients */
            if (drink.ingredients.isNotEmpty()) {
                Spacer(modifier = Modifier.height(innerPadding))
                Text(
                    text = stringResource(id = R.string.title_ingredients),
                    style = MaterialTheme.typography.titleLarge,
                )
                drink.ingredients.forEach {
                    Text(text = it.asString())
                }
            }

            /* Instructions */
            Spacer(modifier = Modifier.height(innerPadding))
            Text(
                text = stringResource(id = R.string.title_recipe),
                style = MaterialTheme.typography.titleLarge,
            )
            Text(text = drink.instructions.asString())
        }
    }
}

@Preview
@Composable
fun DrinkContentPreview() {
    DrinksTheme {
        DrinkContent(
            drink = DrinkUiDetail(
                title = UiText.PlainText("Margarita"),
                mediaUrl = "https://www.thecocktaildb.com/images/media/drink/5noda61589575158.jpg",
                glassLabel = UiText.PlainText("Cocktail glass"),
                ingredients = listOf(
                    UiText.PlainText("1 1/2 oz Tequila"),
                    UiText.PlainText("1/2 oz Triple sec"),
                    UiText.PlainText("1 oz Lime juice"),
                    UiText.PlainText("Salt"),
                ),
                instructions = UiText.PlainText("Rub the rim of the glass with the lime slice."),
                tags = listOf(
                    TagUiItem(
                        label = UiText.PlainText("Alcoholic"),
                        type = DrinkTagType.ALCOHOL,
                    ),
                    TagUiItem(
                        label = UiText.PlainText("Cocktail"),
                        type = DrinkTagType.CATEGORY,
                    ),
                )
            )
        )
    }
}
