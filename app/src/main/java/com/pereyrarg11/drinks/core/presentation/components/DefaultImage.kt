package com.pereyrarg11.drinks.core.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DefaultImage(
    url: String,
    contentDescription: String,
    modifier: Modifier = Modifier,
    @DrawableRes
    resourceId: Int = R.drawable.img_drink_placeholder,
    isPreview: Boolean = LocalInspectionMode.current,
) {
    if (isPreview || url.isBlank()) {
        Image(
            painter = painterResource(id = resourceId),
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Crop,
        )
    } else {
        GlideImage(
            model = url,
            contentDescription = contentDescription,
            modifier = modifier,
            contentScale = ContentScale.Crop,
        )
    }
}

@Preview
@Composable
fun DefaultImagePreview() {
    DrinksTheme {
        DefaultImage(
            url = "https://www.thecocktaildb.com/images/media/drink/dztcv51598717861.jpg",
            contentDescription = "Lorem ipsum",
            modifier = Modifier
                .clip(CircleShape)
                .border(
                    BorderStroke(2.dp, MaterialTheme.colorScheme.primary),
                    CircleShape
                )
                .padding(2.dp)
                .size(100.dp)
        )
    }
}
