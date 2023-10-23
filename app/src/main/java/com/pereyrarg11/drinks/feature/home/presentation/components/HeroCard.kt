package com.pereyrarg11.drinks.feature.home.presentation.components

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun HeroCard(
    label: String,
    imageUrl: String,
    onClickListener: () -> Unit,
    modifier: Modifier = Modifier,
    isPreview: Boolean = LocalInspectionMode.current,
) {
    Card(modifier = modifier.clickable { onClickListener() }) {
        Box {
            if (isPreview) {
                Image(
                    painter = painterResource(id = R.drawable.img_drink_placeholder),
                    contentDescription = label,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop,
                )
            } else {
                GlideImage(
                    model = imageUrl,
                    contentDescription = label,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.Center),
                    contentScale = ContentScale.Crop,
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            0f to Color.Transparent,
                            0.8f to Color.Black.copy(alpha = 0.5f),
                            1f to Color.Black.copy(alpha = 0.9f)
                        )
                    )
            ) {
                Text(
                    text = label,
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
            label = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum aliquam lacus aliquam neque egestas, a gravida erat laoreet.",
            imageUrl = "https://www.thecocktaildb.com/images/media/drink/dztcv51598717861.jpg",
            onClickListener = {},
        )
    }
}