package com.pereyrarg11.drinks.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText

private const val TOP_COLOR_STOP = 0f
private const val MID_COLOR_STOP = 0.8f
private const val BOTTOM_COLOR_STOP = 1f

@Composable
fun HeroCard(
    label: UiText,
    imageUrl: String,
    modifier: Modifier = Modifier,
    onClickListener: () -> Unit = {},
) {
    Card(modifier = modifier.clickable { onClickListener() }) {
        Box {
            DefaultImage(
                url = imageUrl,
                contentDescription = label.asString(),
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            TOP_COLOR_STOP to Color.Transparent,
                            MID_COLOR_STOP to Color.Black.copy(alpha = 0.5f),
                            BOTTOM_COLOR_STOP to Color.Black.copy(alpha = 0.9f)
                        )
                    )
            ) {
                Text(
                    text = label.asString(),
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .fillMaxWidth()
                        .padding(dimensionResource(id = R.dimen.size_md)),
                    color = Color.White,
                    style = MaterialTheme.typography.headlineMedium,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    DrinksTheme {
        HeroCard(
            label = UiText.PlainText("Alcoholic"),
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/dztcv51598717861.jpg",
        )
    }
}
