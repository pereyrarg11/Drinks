package com.pereyrarg11.drinks.feature.splash.presentation

import androidx.lifecycle.viewModelScope
import com.pereyrarg11.drinks.core.logger.error.ErrorLogger
import com.pereyrarg11.drinks.core.presentation.BaseViewModel
import com.pereyrarg11.drinks.feature.splash.presentation.model.SplashUiEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    errorLogger: ErrorLogger,
) : BaseViewModel(errorLogger) {

    private val _navEvent = Channel<SplashUiEvent>()
    val uiEvent = _navEvent.receiveAsFlow()

    init {
        onNext()
    }

    override fun handleError(exception: Exception?) {
    }

    private fun onNext() {
        viewModelScope.launch {
            delay(500)
            _navEvent.send(SplashUiEvent.NavigateToHome)
        }
    }
}
