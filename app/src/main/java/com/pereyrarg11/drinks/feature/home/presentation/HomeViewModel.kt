package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.presentation.BaseViewModel
import com.pereyrarg11.drinks.core.util.error.ErrorLogger
import com.pereyrarg11.drinks.feature.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    errorLogger: ErrorLogger,
    private val repository: HomeRepository,
) : BaseViewModel(errorLogger) {

    var state by mutableStateOf(HomeState())

    init {
        onEvent(HomeEvent.Refresh)
    }

    fun onEvent(event: HomeEvent) {
        when (event) {
            HomeEvent.Refresh -> fetchSections()
        }
    }

    private fun fetchSections() {
        viewModelScope.launch {
            repository.fetchContent().collect { result ->
                when (result) {
                    is DataResult.Success -> {
                        state = state.copy(
                            sections = result.data,
                            isLoading = false,
                            hasError = false
                        )
                    }

                    is DataResult.Error -> {
                        handleError(result.exception)
                    }

                    is DataResult.Loading -> {
                        state = state.copy(
                            isLoading = result.isLoading,
                            hasError = false,
                        )
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
            errorMessage = getErrorMessage(exception),
        )
    }
}
