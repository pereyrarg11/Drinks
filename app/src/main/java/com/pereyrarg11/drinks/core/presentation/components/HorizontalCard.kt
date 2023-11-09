package com.pereyrarg11.drinks.core.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText

@Composable
fun HorizontalCard(
    label: UiText,
    imageUrl: String,
    modifier: Modifier = Modifier,
    height: Dp = dimensionResource(id = R.dimen.horizontal_card_height),
    onClickListener: () -> Unit = {},
) {
    Card(
        modifier = modifier
            .height(height)
            .clickable { onClickListener() },
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            DefaultImage(
                url = imageUrl,
                contentDescription = label.asString(),
                modifier = Modifier.size(height),
            )

            Text(
                text = label.asString(),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(id = R.dimen.size_md)),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
            )
        }
    }
}

@Preview
@Composable
fun HorizontalCardPreview() {
    DrinksTheme {
        HorizontalCard(
            label = UiText.PlainText("Cocktail"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/yqvvqs1475667388.jpg",
        )
    }
}