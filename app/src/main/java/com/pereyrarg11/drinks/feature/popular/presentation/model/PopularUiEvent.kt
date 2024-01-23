package com.pereyrarg11.drinks.feature.popular.presentation.model

sealed class PopularUiEvent {
    data class NavigateToDrinkDetail(val drinkId: String) : PopularUiEvent()
}
