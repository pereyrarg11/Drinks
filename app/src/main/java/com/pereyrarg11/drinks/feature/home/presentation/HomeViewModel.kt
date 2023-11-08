package com.pereyrarg11.drinks.feature.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.R
import com.pereyrarg11.drinks.core.domain.util.DataResult
import com.pereyrarg11.drinks.core.presentation.util.UiText
import com.pereyrarg11.drinks.feature.home.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

// TODO: extend from BaseViewModel
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository,
) : ViewModel() {

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
                state = when (result) {
                    is DataResult.Success -> {
                        state.copy(
                            sections = result.data,
                            isLoading = false,
                            hasError = false
                        )
                    }

                    is DataResult.Error -> {
                        state.copy(
                            hasError = true,
                            errorMessage = UiText.StringResource(R.string.error_default),
                            isLoading = false,
                        )
                    }

                    is DataResult.Loading -> {
                        state.copy(
                            isLoading = result.isLoading,
                            hasError = false,
                        )
                    }
                }
            }
        }
    }
}
