package com.pereyrarg11.drinks.core.domain.usecase

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EscapeTextUseCase @Inject constructor() {
    operator fun invoke(text: String): String = text.replace(" ", "_")
}
