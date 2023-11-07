package com.pereyrarg11.drinks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pereyrarg11.drinks.core.presentation.navigation.ScreenRoute
import com.pereyrarg11.drinks.core.presentation.theme.DrinksTheme
import com.pereyrarg11.drinks.feature.filter.presentation.FilterScreen
import com.pereyrarg11.drinks.feature.home.presentation.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrinksAppContent()
        }
    }
}

@Composable
fun DrinksAppContent(
    modifier: Modifier = Modifier,
) {
    DrinksTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = ScreenRoute.Home.route
            ) {
                composable(ScreenRoute.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(ScreenRoute.Filter.route) {
                    FilterScreen(navController = navController)
                }
            }
        }
    }
}
