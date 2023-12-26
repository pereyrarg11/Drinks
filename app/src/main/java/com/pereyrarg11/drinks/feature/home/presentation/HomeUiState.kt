package com.pereyrarg11.drinks.feature.home.presentation

import com.pereyrarg11.drinks.core.presentation.model.UiState
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.home.domain.model.HomeSectionModel

data class HomeUiState(
    override val isLoading: Boolean = false,
    override val hasError: Boolean = false,
    override val errorMessage: UiText = UiText.PlainText(""),
    val sections: List<HomeSectionModel> = emptyList(),
) : UiState
