package com.pereyrarg11.drinks.core.domain.usecase

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoveLineBreaksUseCase @Inject constructor() {
    private val lineBreakRegex = Regex("[\r\n]+")

    operator fun invoke(text: String): String = text.replace(lineBreakRegex, " ")
}
