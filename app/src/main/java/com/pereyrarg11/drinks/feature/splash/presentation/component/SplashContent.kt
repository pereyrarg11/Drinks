package com.pereyrarg11.drinks.feature.splash.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.BuildConfig
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.components.DefaultImage
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme

@Composable
fun SplashContent(
    modifier: Modifier = Modifier,
    versionName: String = BuildConfig.VERSION_NAME,
) {
    Box(
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize()
            .padding(dimensionResource(id = R.dimen.splash_padding_content))
    ) {
        DefaultImage(
            url = "",
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.Center)
                .size(dimensionResource(id = R.dimen.splash_size_icon)),
            resourceId = R.drawable.ic_launcher_foreground,
        )

        Text(
            text = "v$versionName",
            modifier = Modifier.align(Alignment.BottomCenter),
            color = Color.Black,
            style = MaterialTheme.typography.titleLarge,
        )
    }
}

@Preview
@Composable
fun DarkSplashContentPreview() {
    DrinksTheme(darkTheme = false) {
        SplashContent()
    }
}

@Preview
@Composable
fun LightSplashContentPreview() {
    DrinksTheme(darkTheme = true) {
        SplashContent()
    }
}
