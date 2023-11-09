package com.pereyrarg11.drinks.core.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText

@Composable
fun CircleCard(
    label: UiText,
    imageUrl: String,
    modifier: Modifier = Modifier,
    imageSize: Dp = dimensionResource(id = R.dimen.circle_card_image_size),
    onClickListener: () -> Unit = {},
) {
    Column(
        modifier = modifier.width(imageSize.times(1.3f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val strokeWidth = dimensionResource(id = R.dimen.circle_card_stroke_width)

        DefaultImage(
            url = imageUrl,
            contentDescription = label.asString(),
            modifier = Modifier
                .size(imageSize)
                .clickable { onClickListener() }
                .clip(CircleShape)
                .border(
                    BorderStroke(strokeWidth, MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(strokeWidth)
        )

        Text(
            text = label.asString(),
            modifier = Modifier
                .fillMaxWidth()
                .paddingFromBaseline(
                    top = dimensionResource(id = R.dimen.size_lg),
                    bottom = dimensionResource(id = R.dimen.size_sm)
                ),
            textAlign = TextAlign.Center,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Preview
@Composable
fun CircleCardPreview() {
    DrinksTheme {
        CircleCard(
            label = UiText.PlainText("Tequila"),
            imageUrl = "https://www.thecocktaildb.com/images/ingredients/tequila.png",
        )
    }
}