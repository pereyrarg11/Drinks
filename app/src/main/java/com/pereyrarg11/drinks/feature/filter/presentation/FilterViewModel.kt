package com.pereyrarg11.drinks.feature.filter.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.domain.model.DrinkModel
import com.pereyrarg11.drinks.core.domain.model.FilterType
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.presentation.model.DrinkDisplayable
import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants
import com.pereyrarg11.drinks.feature.filter.domain.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilterViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val repository: FilterRepository,
    private val drinkListConverter: Converter<List<DrinkModel>, List<DrinkDisplayable>>,
) : ViewModel() {
    var state by mutableStateOf(FilterState())

    init {
        viewModelScope.launch {
            // TODO: show error message when some param is missing
            val filterType =
                savedStateHandle.get<String>(NavConstants.FILTER_TYPE_PARAM) ?: return@launch
            val query = savedStateHandle.get<String>(NavConstants.QUERY_PARAM) ?: return@launch

            val filterFlow = when (FilterType.findByParam(filterType)) {
                FilterType.ALCOHOL -> repository.filterDrinksByAlcohol(query)
                FilterType.CATEGORY -> repository.filterDrinksByCategory(query)
                FilterType.INGREDIENT -> repository.filterDrinksByIngredient(query)
                FilterType.UNKNOWN -> return@launch
            }

            filterFlow.collect { result ->
                state = when (result) {
                    is DataResult.Success -> {
                        state.copy(
                            isLoading = false,
                            hasError = false,
                            drinks = drinkListConverter.convert(result.data)
                        )
                    }

                    is DataResult.Error -> {
                        state.copy(isLoading = false, hasError = true)
                    }

                    is DataResult.Loading -> {
                        state.copy(isLoading = result.isLoading, hasError = false)
                    }
                }
            }
        }
    }
}
