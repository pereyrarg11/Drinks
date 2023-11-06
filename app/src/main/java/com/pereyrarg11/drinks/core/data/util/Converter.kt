package com.pereyrarg11.drinks.core.data.util

interface Converter<Input, Output> {
    fun convert(input: Input): Output
}
