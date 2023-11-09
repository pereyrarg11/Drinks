package com.pereyrarg11.drinks.feature.drink.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.data.util.Converter
import com.pereyrarg11.drinks.core.data.util.MissingQueryParamsException
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.presentation.BaseViewModel
import com.pereyrarg11.drinks.core.presentation.navigation.NavConstants.ID_PARAM
import com.pereyrarg11.drinks.feature.drink.domain.model.DrinkDetailModel
import com.pereyrarg11.drinks.feature.drink.domain.usecase.GetDrinkUseCase
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkUiDetail
import com.pereyrarg11.drinks.feature.drink.presentation.model.DrinkUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DrinkViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    val getDrink: GetDrinkUseCase,
    val converter: Converter<DrinkDetailModel, DrinkUiDetail>,
) : BaseViewModel() {

    // TODO: look for a way to move this property to abstract class
    var uiState by mutableStateOf(DrinkUiState(isLoading = true))

    init {
        val id = savedStateHandle.get<String>(ID_PARAM)

        if (!id.isNullOrBlank()) {
            fetchDrinkById(id)
        } else {
            handleError(MissingQueryParamsException(ID_PARAM))
        }
    }

    private fun fetchDrinkById(id: String) {
        viewModelScope.launch {
            getDrink(id).collect { result ->
                when (result) {
                    is DataResult.Error -> handleError(result.exception)
                    is DataResult.Loading -> {
                        uiState = uiState.copy(isLoading = result.isLoading, hasError = false)
                    }

                    is DataResult.Success -> {
                        uiState = uiState.copy(
                            isLoading = false,
                            hasError = false,
                            drink = converter.convert(result.data),
                        )
                    }
                }
            }
        }
    }

    override fun handleError(exception: Exception?) {
        if (exception != null) logException(exception)

        uiState = uiState.copy(
            isLoading = false,
            hasError = true,
            errorMessage = getErrorMessage(exception),
        )
    }
}
