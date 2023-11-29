package com.pereyrarg11.drinks.core.domain.usecase

import javax.inject.Inject

class UnescapeTextUseCase @Inject constructor() {
    operator fun invoke(text: String): String = text.replace("_", " ")
}
