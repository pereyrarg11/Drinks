package com.pereyrarg11.drinks.feature.drink.presentation.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Liquor
import androidx.compose.material.icons.filled.Tapas
import androidx.compose.material.icons.filled.Widgets
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkTagType.*
import com.pereyrarg11.drinks.feature.drink.presentation.model.TagUiItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TagRow(
    tags: List<TagUiItem>,
    modifier: Modifier = Modifier,
    onClickListener: (TagUiItem) -> Unit = {},
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.size_sm))
    ) {
        tags.forEach { tag ->
            val imageVector = when (tag.type) {
                ALCOHOL -> Icons.Filled.Liquor
                CATEGORY -> Icons.Filled.Tapas
                UNKNOWN -> Icons.Filled.Widgets
            }
            val color = when (tag.type) {
                ALCOHOL -> MaterialTheme.colorScheme.primary
                CATEGORY -> MaterialTheme.colorScheme.secondary
                UNKNOWN -> MaterialTheme.colorScheme.onSurface
            }

            AssistChip(
                onClick = { onClickListener(tag) },
                label = { Text(text = tag.label.asString()) },
                leadingIcon = {
                    Icon(
                        imageVector = imageVector,
                        contentDescription = tag.label.asString()
                    )
                },
                colors = AssistChipDefaults.assistChipColors(
                    labelColor = color,
                    leadingIconContentColor = color,
                )
            )
        }
    }
}

@Preview
@Composable
fun TagRowPreview() {
    DrinksTheme {
        TagRow(
            tags = listOf(
                TagUiItem(
                    label = UiText.PlainText("Alcoholic"),
                    type = ALCOHOL,
                ),
                TagUiItem(
                    label = UiText.PlainText("Cocktail"),
                ),
                TagUiItem(
                    label = UiText.PlainText("Shot"),
                    type = CATEGORY,
                ),
                TagUiItem(
                    label = UiText.PlainText("Other"),
                ),
                TagUiItem(
                    label = UiText.PlainText("Non alcoholic"),
                    type = ALCOHOL,
                ),
            )
        )
    }
}
