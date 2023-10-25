package com.pereyrarg11.drinks.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    message: String = stringResource(R.string.error_default),
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = Icons.Default.Build,
                contentDescription = message,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_lg)))
            Text(text = message)
        }
    }
}

@Preview
@Composable
fun ErrorScreenPreview() {
    DrinksTheme {
        ErrorScreen()
    }
}