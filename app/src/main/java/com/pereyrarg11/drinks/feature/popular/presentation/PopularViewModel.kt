package com.pereyrarg11.drinks.feature.popular.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.di.EntitySummaryConverter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.logger.error.ErrorLogger
import com.pereyrarg11.drinks.core.presentation.BaseViewModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkUiItem
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.popular.analytics.PopularAnalyticsLogger
import com.pereyrarg11.drinks.feature.popular.domain.repository.PopularRepository
import com.pereyrarg11.drinks.feature.popular.presentation.model.PopularUiEvent
import com.pereyrarg11.drinks.feature.popular.presentation.model.PopularUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    private val repository: PopularRepository,
    @EntitySummaryConverter private val converter: Converter<List<DrinkModel>, List<DrinkUiItem>>,
    private val analyticsLogger: PopularAnalyticsLogger,
) : BaseViewModel(errorLogger) {

    private val _uiEvent = Channel<PopularUiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    var uiState by mutableStateOf(PopularUiState(isLoading = true))

    init {
        analyticsLogger.enterToScreen()
        fetchPopularDrinks()
    }

    override fun handleError(exception: Exception?) {
        exception?.let { logException(it) }
        uiState = uiState.copy(
            isLoading = false,
            hasError = true,
            errorMessage = getErrorMessage(exception),
            drinks = emptyList(),
        )
    }

    fun onClickDrink(drink: DrinkUiItem) {
        analyticsLogger.clickDrink(
            drinkId = drink.id,
            drinkName = if (drink.label is UiText.PlainText) drink.label.value else ""
        )
        viewModelScope.launch {
            _uiEvent.send(PopularUiEvent.NavigateToDrinkDetail(drinkId = drink.id))
        }
    }

    private fun fetchPopularDrinks() {
        viewModelScope.launch {
            repository.getPopularDrinks().collect { result ->
                when (result) {
                    is DataResult.Error -> handleError(result.exception)
                    is DataResult.Loading -> uiState =
                        uiState.copy(isLoading = result.isLoading, hasError = false)

                    is DataResult.Success -> uiState =
                        uiState.copy(
                            isLoading = false,
                            hasError = false,
                            drinks = converter.convert(result.data)
                        )
                }
            }
        }
    }
}
