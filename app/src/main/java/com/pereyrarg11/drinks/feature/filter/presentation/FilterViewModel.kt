package com.pereyrarg11.drinks.feature.filter.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.data.util.MissingParamsException
import com.pereyrarg11.drinks.core.di.EntitySummaryConverter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.domain.usecase.UnescapeTextUseCase
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.logger.error.ErrorLogger
import com.pereyrarg11.drinks.core.presentation.BaseViewModel
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.filter.analytics.FilterAnalyticsLogger
import com.pereyrarg11.drinks.feature.filter.domain.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    errorLogger: ErrorLogger,
    private val repository: FilterRepository,
    @EntitySummaryConverter private val drinkListConverter: Converter<List<DrinkModel>, List<DrinkDisplayable>>,
    val unescapeTextUseCase: UnescapeTextUseCase,
    private val analyticsLogger: FilterAnalyticsLogger,
) : BaseViewModel(errorLogger) {

    var state by mutableStateOf(FilterState(isLoading = true))

    init {
        val filterTypeParam = savedStateHandle.get<String>(NavConstants.FILTER_TYPE_PARAM).orEmpty()
        val queryParam = savedStateHandle.get<String>(NavConstants.QUERY_PARAM).orEmpty()
        val filterType = FilterType.findByParam(filterTypeParam)

        if (filterTypeParam.isNotBlank() && queryParam.isNotBlank()) {
            setTitleFromQueryParam(queryParam)
            fetchDrinksByFilterType(filterType, queryParam)
        } else {
            handleError(MissingParamsException())
        }
        analyticsLogger.enterToScreen(filterType.name, queryParam)
    }

    private fun setTitleFromQueryParam(query: String) {
        val title = unescapeTextUseCase(query)
        state = state.copy(title = UiText.PlainText(title))
    }

    private fun fetchDrinksByFilterType(filterType: FilterType, query: String) {
        viewModelScope.launch {
            when (filterType) {
                FilterType.ALCOHOL -> repository.filterDrinksByAlcohol(query)
                FilterType.CATEGORY -> repository.filterDrinksByCategory(query)
                FilterType.INGREDIENT -> repository.filterDrinksByIngredient(query)
                FilterType.UNKNOWN -> return@launch
            }.collect { result ->
                when (result) {
                    is DataResult.Success -> {
                        state = state.copy(
                            isLoading = false,
                            hasError = false,
                            drinks = drinkListConverter.convert(result.data)
                        )
                    }

                    is DataResult.Error -> {
                        handleError(result.exception)
                    }

                    is DataResult.Loading -> {
                        state = state.copy(isLoading = result.isLoading, hasError = false)
                    }
                }
            }
        }
    }

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)

        state = state.copy(
            isLoading = false,
            hasError = true,
            errorMessage = getErrorMessage(exception)
        )
    }

    fun onClickDrink(drink: DrinkDisplayable) {
        analyticsLogger.clickDrink(
            drink.id,
            drinkName = if (drink.label is UiText.PlainText) drink.label.value else ""
        )
    }
}
