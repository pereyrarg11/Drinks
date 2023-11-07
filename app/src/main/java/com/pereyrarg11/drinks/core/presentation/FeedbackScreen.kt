package com.pereyrarg11.drinks.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.core.presentation.util.UiText

/**
 * This function SHOULD NOT be called directly from Screen components.
 * Use [NoResultsScreen] or [ErrorScreen] instead, or create a new component.
 */
@Composable
fun FeedbackScreen(
    message: UiText,
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(dimensionResource(id = R.dimen.size_md))
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = message.asString(),
                modifier = Modifier.size(dimensionResource(id = R.dimen.feedback_screen_icon_size))
            )
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.size_lg)))
            Text(
                text = message.asString(),
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Preview
@Composable
fun FeedbackScreenPreview() {
    DrinksTheme {
        FeedbackScreen(
            message = UiText.PlainText("There are not more tasks to do."),
            imageVector = Icons.Default.Done,
        )
    }
}
