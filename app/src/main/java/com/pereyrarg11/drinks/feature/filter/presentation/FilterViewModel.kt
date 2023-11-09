package com.pereyrarg11.drinks.feature.filter.presentation

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.data.util.MissingParamsException
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.domain.use_case.UnescapeTextUseCase
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.filter.domain.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: extend from BaseViewModel
@HiltViewModel
class FilterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: FilterRepository,
    private val drinkListConverter: Converter<List<DrinkModel>, List<DrinkDisplayable>>,
    val unescapeTextUseCase: UnescapeTextUseCase,
) : ViewModel() {
    var state by mutableStateOf(FilterState(isLoading = true))

    init {
        val filterType = savedStateHandle.get<String>(NavConstants.FILTER_TYPE_PARAM)
        val query = savedStateHandle.get<String>(NavConstants.QUERY_PARAM)

        if (filterType != null && query != null) {
            setTitleFromQueryParam(query)
            fetchDrinksByFilterType(FilterType.findByParam(filterType), query)
        } else {
            handleError(MissingParamsException())
        }
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

    private fun handleError(exception: Exception?) {
        if (exception != null) {
            // TODO: log this exception through ErrorLogger or similar
            Log.e("FilterViewModel", "handleError: ${exception.message}")
        }

        val errorMessage = when (exception) {
            is MissingParamsException -> UiText.StringResource(R.string.error_missing_query_params)
            else -> UiText.StringResource(R.string.error_default)
        }

        state = state.copy(
            isLoading = false,
            hasError = true,
            errorMessage = errorMessage
        )
    }
}
