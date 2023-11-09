package com.pereyrarg11.drinks.core.data.util

interface Converter<Input, Output> {
    // TODO: look for a way to turn this function into an operator fun
    fun convert(input: Input): Output
}
